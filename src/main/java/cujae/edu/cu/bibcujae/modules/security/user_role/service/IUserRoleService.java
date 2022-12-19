package cujae.edu.cu.bibcujae.modules.security.user_role.service;

import java.sql.SQLException;
import java.util.List;

import cujae.edu.cu.bibcujae.modules.security.role.dto.RoleDto;
import cujae.edu.cu.bibcujae.modules.security.role.entity.RoleEntity;
import cujae.edu.cu.bibcujae.modules.security.user_role.entity.UserRoleEntity;

public interface IUserRoleService {

    /*
     * Método para agregar un rol a un usuario.
     */
    UserRoleEntity addRoleToUser(Long idRole, Long idUser) throws SQLException;

    /*
     * Método para obtener los roles de un usuario.
     */
    List<RoleDto> getRolesByUser(Long user);
}