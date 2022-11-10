package cujae.edu.cu.bibcujae.modules.security.user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import cujae.edu.cu.bibcujae.modules.security.user.dto.UpdateUserDto;
import cujae.edu.cu.bibcujae.modules.security.user.dto.UserDto;
import cujae.edu.cu.bibcujae.modules.security.user.entity.UserEntity;

public interface IUserService {

	/*
	 * Método para crear un nuevo usuario.
	 */
	UserEntity createUser(UserDto user) throws SQLException;

	/*
	 * Método para actualizar un usuario.
	 */
	UserEntity updateUser(Long id, UpdateUserDto user);

	/*
	 * Método para obtener a todos los usuarios.
	 */
	List<UserEntity> listUsers() throws SQLException;

	/*
	 * Método para obtener a un usuario por el ID.
	 */
	Optional<UserEntity> getUserById(Long userId) throws SQLException;

	/*
	 * Eliminar un usuario.
	 */
	void deleteUser(Long id) throws SQLException;
}