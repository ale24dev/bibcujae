package cujae.edu.cu.bibcujae.modules.security.role.service;

import java.util.List;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import cujae.edu.cu.bibcujae.modules.security.role.dto.RoleDto;
import cujae.edu.cu.bibcujae.modules.security.role.entity.RoleEntity;
import cujae.edu.cu.bibcujae.modules.exception.ResourceNotFoundException;
import cujae.edu.cu.bibcujae.modules.security.role.repository.RoleRepository;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> listRoles() throws SQLException {
        List<RoleEntity> listRoles = roleRepository.findAll();
        return listRoles;
    }

    @Override
    public RoleEntity getRoleById(Long roleId) throws SQLException {
        RoleEntity role = roleRepository.findById(roleId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", roleId));

        return role;
    }

    public RoleDto castRoleEntityToDto(RoleEntity roleEntity) {
        RoleDto roleDto = new RoleDto();

        roleDto.setIdRole(roleEntity.getIdRole());
        roleDto.setName(roleEntity.getName());

        return roleDto;
    }

}