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
@RequestMapping("bibcujae/api/v1/users")
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
    public ResponseEntity<List<UserEntity>> getUsers() throws SQLException {
        List<UserEntity> userList = userService.listUsers();
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
     * Crear un usuario.
     */
    @PostMapping("/")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDto user) throws SQLException {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(user);
        UserEntity userEntity = userService.createUser(user);
        return ResponseEntity.ok(userEntity);
    }

    /*
     * Actualizar un usuario.
     */
    @PutMapping("/id/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto)
            throws SQLException {
        return ResponseEntity.ok(userService.updateUser(id, updateUserDto));
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