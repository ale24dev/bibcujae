package cujae.edu.cu.bibcujae.modules.security.role.controller;

import java.util.List;
import java.sql.SQLException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cujae.edu.cu.bibcujae.modules.security.role.entity.RoleEntity;
import cujae.edu.cu.bibcujae.modules.security.role.service.IRoleService;
import cujae.edu.cu.bibcujae.modules.security.user_role.entity.UserRoleEntity;
import cujae.edu.cu.bibcujae.modules.security.user_role.service.IUserRoleService;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserRoleService userRoleService;

    @PostMapping("/add-role/{idRole}/user/{idUser}")
    public ResponseEntity<UserRoleEntity> addRoleToUser(@PathVariable Long idUser, @PathVariable Long idRole)
            throws SQLException {
        UserRoleEntity userRole = userRoleService.addRoleToUser(idRole, idUser);
        return ResponseEntity.ok(userRole);
    }

    @GetMapping("/")
    public ResponseEntity<List<RoleEntity>> getRoles() throws SQLException {
        List<RoleEntity> roleList = roleService.listRoles();
        return ResponseEntity.ok(roleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleEntity> geRoleById(@PathVariable Long id) throws SQLException {
        RoleEntity role = roleService.getRoleById(id);
        return ResponseEntity.ok(role);
    }

   /*  @GetMapping("/user/{idUser}")
    public ResponseEntity<List<RoleEntity>> geRoleByUserId(@PathVariable String idUser) throws SQLException {
        List<RoleEntity> roleList = userRoleService.getRolesByUser(idUser);
        return ResponseEntity.ok(roleList);
    }*/

}
