package cujae.edu.cu.bibcujae.modules.security.user.service;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cujae.edu.cu.bibcujae.modules.security.user.dto.UserDto;
import cujae.edu.cu.bibcujae.modules.exception.ResourceNotFoundException;
import cujae.edu.cu.bibcujae.modules.security.role.service.RoleService;
import cujae.edu.cu.bibcujae.modules.security.user.dto.UpdateUserDto;
import cujae.edu.cu.bibcujae.modules.security.user.entity.UserEntity;
import cujae.edu.cu.bibcujae.modules.security.user.repositories.UserRepository;
import cujae.edu.cu.bibcujae.modules.security.user_role.entity.UserRoleEntity;
import cujae.edu.cu.bibcujae.modules.security.user_role.repository.UserRoleRepository;
import cujae.edu.cu.bibcujae.modules.security.user_role.service.UserRoleService;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserEntity createUser(UserDto user) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(encodePass(user.getPassword()));
        userEntity.setFullname(user.getFullname());
        userEntity.setEmail(user.getEmail());
        UserEntity userCreated = userRepository.save(userEntity);

        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUser(userCreated);
        userRoleEntity.setRole(roleService.getRoleById(Long.parseLong("2")));
        userRoleRepository.save(userRoleEntity);

        return userCreated;
    }

    @Override
    public void updateUser(UpdateUserDto user) {
        try {
            UserEntity userFound = this.getUserById(user.getId());

            if (user.getUsername().length() != 0) {
                userFound.setUsername(user.getUsername());
            }
            if (user.getPassword().length() != 0) {
                userFound.setPassword(UserService.encodePass(user.getPassword()));
            }
            if (user.getEmail().length() != 0) {
                userFound.setEmail(user.getEmail());
            }
            if (user.getFullname().length() != 0) {
                userFound.setFullname(user.getFullname());
            }
            userRepository.save(userFound);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserEntity> listUsers() throws SQLException {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long userId) throws SQLException {
        UserEntity user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", userId));

        return user;
    }

    @Override
    public UserDto getUserByUsername(String username) throws SQLException {
        List<UserEntity> listUser = this.listUsers();
        UserDto userFound = new UserDto();

        for (UserEntity userEntity : listUser) {
            if (userEntity.getUsername().trim().equals(username)) {
                userFound = castUserEntityToDto(userEntity);

                userFound.setRoles(userRoleService.getRolesByUser(userEntity.getIdUser()));
                return userFound;
            }
        }
        throw new UsernameNotFoundException("User not found.");
    }

    @Override
    public void deleteUser(Long id) throws SQLException {

        UserEntity user = getUserById(id);

        userRepository.delete(user);
        // TODO Auto-generated method stub

    }

    private static String encodePass(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    /*
     * Castear un UserEntity a UserDto
     */
    @Override
    public UserDto castUserEntityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();

        userDto.setId(userEntity.getIdUser());
        userDto.setUsername(userEntity.getUsername().trim());
        userDto.setPassword(userEntity.getPassword().trim());
        userDto.setFullname(userEntity.getFullname());
        userDto.setEmail(userEntity.getEmail());
        /// Falta agregar los roles
        // userDto.setListRoles(userEntity.get());

        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() throws SQLException {
        List<UserEntity> lEntities = userRepository.findAll();
        List<UserDto> listUser = new ArrayList<UserDto>();

        for (UserEntity iter : lEntities) {
            listUser.add(castUserEntityToDto(iter));
        }
        return listUser;
    }

}