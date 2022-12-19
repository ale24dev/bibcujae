package cujae.edu.cu.bibcujae.modules.security.user.service;

import java.util.List;
import java.sql.SQLException;

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
	UserEntity getUserById(Long userId) throws SQLException;

	/*
	 * Método para obtener a un usuario por el username.
	 */
	UserDto getUserByUsername(String username) throws SQLException;

	/*
	 * Eliminar un usuario.
	 */
	void deleteUser(Long id) throws SQLException;

	/*
	 * Castear un UserEntity a Dto
	 */
	UserDto castUserEntityToDto(UserEntity userEntity);
}