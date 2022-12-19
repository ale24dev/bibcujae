package cujae.edu.cu.bibcujae.modules.security.user_role.service;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cujae.edu.cu.bibcujae.modules.security.user.dto.UpdateUserDto;
import cujae.edu.cu.bibcujae.modules.security.user.entity.UserEntity;
import cujae.edu.cu.bibcujae.modules.security.role.dto.RoleDto;
import cujae.edu.cu.bibcujae.modules.security.role.entity.RoleEntity;
import cujae.edu.cu.bibcujae.modules.security.role.service.RoleService;
import cujae.edu.cu.bibcujae.modules.security.user.service.UserService;
import cujae.edu.cu.bibcujae.modules.security.user_role.entity.UserRoleEntity;
import cujae.edu.cu.bibcujae.modules.security.user_role.repository.UserRoleRepository;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRoleEntity addRoleToUser(Long idUser, Long idRole) throws SQLException {

        UserEntity userEntity = userService.getUserById(idUser);
        RoleEntity roleEntity = roleService.getRoleById(idRole);

        if (!checkRoleInUser(idUser, idRole)) {
            return null;
        }
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUser(userEntity);
        userRoleEntity.setRole(roleEntity);

        UserRoleEntity userRoleSaved = userRoleRepository.save(userRoleEntity);

        return userRoleSaved;
    }

    @Override
    public List<RoleDto> getRolesByUser(Long idUser) {
        List<UserRoleEntity> listUserRole = userRoleRepository.findAll();

        List<RoleDto> listRoles = new ArrayList<RoleDto>();

        for (UserRoleEntity userRoleEntity : listUserRole) {
            if (userRoleEntity.getUser().getIdUser() == idUser) {
                listRoles.add(roleService.castRoleEntityToDto(userRoleEntity.getRole()));
            }
        }
        
        return listRoles;
    }

    /// Función para verificar si un usuario ya tiene un rol específico
    private boolean checkRoleInUser(Long idUser, Long idRole) {
        List<UserRoleEntity> listUserRole = userRoleRepository.findAll();

        for (UserRoleEntity userRoleEntity : listUserRole) {
            if (userRoleEntity.getUser().getIdUser() == idUser && userRoleEntity.getRole().getIdRole() == idRole)
                return true;
        }
        return false;
    }
}
