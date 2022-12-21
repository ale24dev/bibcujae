package cujae.edu.cu.bibcujae.modules.security.role.service;

import java.util.List;
import java.sql.SQLException;

import cujae.edu.cu.bibcujae.modules.security.role.dto.RoleDto;
import cujae.edu.cu.bibcujae.modules.security.role.entity.RoleEntity;

public interface IRoleService {

    List<RoleDto> listRoles() throws SQLException;

    RoleEntity getRoleById(Long roleId) throws SQLException;

}