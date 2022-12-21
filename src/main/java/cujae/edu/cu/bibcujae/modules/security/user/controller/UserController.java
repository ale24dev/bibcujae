package cujae.edu.cu.bibcujae.modules.security.user.controller;

import java.util.List;
import java.sql.SQLException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import cujae.edu.cu.bibcujae.modules.security.user.dto.UpdateUserDto;
import cujae.edu.cu.bibcujae.modules.security.user.dto.UserDto;
import cujae.edu.cu.bibcujae.modules.security.user.entity.UserEntity;
import cujae.edu.cu.bibcujae.modules.security.user.service.IUserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    /*
     * Instancia de la clase de servicios de usuario.
     */
    @Autowired
    private IUserService userService;

    /*
     * Obtener todos los usuarios
     */
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers() throws SQLException {
        List<UserDto> userList = userService.getAllUsers();
        System.out.println(userList.get(0));
        return ResponseEntity.ok(userList);
    }

    /*
     * Obtener un usuario por id.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) throws SQLException {
        UserEntity userEntity = userService.getUserById(id);
        return ResponseEntity.ok(userEntity);
    }

    

    /*
     * Actualizar un usuario.
     */
    @PutMapping("")
    public ResponseEntity<String> updateUser(@RequestBody UpdateUserDto updateUserDto)
            throws SQLException {
                userService.updateUser(updateUserDto);
        return ResponseEntity.ok("Usuario Actualizado");
    }

    /*
     * Eliminar un usuario.
     */
    @DeleteMapping("/id/{id}")
    public void deleteUser(@PathVariable Long id)
            throws SQLException {
        this.userService.deleteUser(id);       
    }
}