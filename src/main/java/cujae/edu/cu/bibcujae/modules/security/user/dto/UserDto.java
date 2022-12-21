package cujae.edu.cu.bibcujae.modules.security.user.dto;

import java.util.List;

import cujae.edu.cu.bibcujae.modules.security.role.dto.RoleDto;

/*
 * Clase encargada de gestionar a los usuarios.
 */
public class UserDto {
	/*
	 * Identificación del usuario.
	 */
	private Long id;

	/*
	 * Nombre de usuario.
	 */
	private String username;
	/*
	 * Contraseña del usuario.
	 */
	private String password;

	/*
	 * Nombre completo del usuario.
	 */
	private String fullname;

	/*
	 * Email de usuario.
	 */
	private String email;

	/*
	 * Token del usuario.
	 */
	private String token;

	/*
	 * Listado de roles
	 */
	private List<RoleDto> roles;

	public UserDto() {
		super();
	}

	public UserDto(Long id, String username, String password, String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", token=" + token
				+ ", roles=" + roles + "]";
	}
}
