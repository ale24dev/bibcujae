package cujae.edu.cu.bibcujae.modules.security.auth.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cujae.edu.cu.bibcujae.modules.email.EmailSenderService;
import cujae.edu.cu.bibcujae.modules.email.Mail;
import cujae.edu.cu.bibcujae.modules.security.auth.dto.LoginRequestDto;
import cujae.edu.cu.bibcujae.modules.security.auth.dto.UserAuthenticatedDto;
import cujae.edu.cu.bibcujae.modules.security.auth.services.TokenProvider;
import cujae.edu.cu.bibcujae.modules.security.user.dto.UserDto;
import cujae.edu.cu.bibcujae.modules.security.user.entity.UserEntity;
import cujae.edu.cu.bibcujae.modules.security.user.service.UserService;
import freemarker.template.TemplateException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    EmailSenderService emailSenderService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequestDto loginRequestDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
                            loginRequestDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = tokenProvider.createToken(authentication);

            UserDto user = userService.getUserByUsername(loginRequestDto.getUsername());
            UserAuthenticatedDto userAuth = new UserAuthenticatedDto(user.getId(), user.getUsername(),
                    user.getPassword(),
                    user.getRoles(), token);

            return ResponseEntity.ok(userAuth);
        } catch (BadCredentialsException | SQLException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }

    /*
     * Crear un usuario.
     */
    @PostMapping("/signup")
    public ResponseEntity<UserEntity> signUp(@RequestBody UserDto user)
            throws SQLException, MessagingException, IOException, TemplateException {
        UserEntity userEntity = userService.createUser(user);
        System.out.println("USERNAME: " + user.getFullname() + " EMAIL: " + user.getEmail());
        emailSenderService.sendEmailToUserWithCredentials(user.getFullname(), user.getEmail());

        return ResponseEntity.ok(userEntity);
    }

}
