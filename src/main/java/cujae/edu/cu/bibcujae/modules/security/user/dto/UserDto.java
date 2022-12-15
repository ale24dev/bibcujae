package cujae.edu.cu.bibcujae.modules.security.user.dto;

import lombok.Data;

/*
 * Clase encargada de gestionar a los usuarios.
 */
@Data
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

	public UserDto() {
		super();
	}

	public UserDto(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
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
}
