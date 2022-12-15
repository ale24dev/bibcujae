package cujae.edu.cu.bibcujae.modules.security.user.service;

import java.util.List;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import cujae.edu.cu.bibcujae.modules.security.user.dto.UserDto;
import cujae.edu.cu.bibcujae.modules.exception.ResourceNotFoundException;
import cujae.edu.cu.bibcujae.modules.security.user.dto.UpdateUserDto;
import cujae.edu.cu.bibcujae.modules.security.user.entity.UserEntity;
import cujae.edu.cu.bibcujae.modules.security.user.repositories.UserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserDto user) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        UserEntity userCreated = userRepository.save(userEntity);
        return userCreated;
    }

    @Override
    public UserEntity updateUser(Long id, UpdateUserDto user) {
        UserEntity userUpdated = null;
        try {
            UserEntity userFound = this.getUserById(id);

            if (user.getUsername().length() != 0) {
                userFound.setUsername(user.getUsername());
            }
            if (user.getPassword().length() != 0) {
                userFound.setPassword(user.getPassword());
            }
            userUpdated = userRepository.save(userFound);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userUpdated;
    }

    @Override
    public List<UserEntity> listUsers() throws SQLException {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long userId) throws SQLException {
        UserEntity user = userRepository.findById(userId).orElseThrow(
            ()-> new ResourceNotFoundException("Post", "id", userId)
        );
        
        return user;
    }

    @Override
    public void deleteUser(Long id) throws SQLException {

        UserEntity user = getUserById(id);

        userRepository.delete(user);
        // TODO Auto-generated method stub

    }

}