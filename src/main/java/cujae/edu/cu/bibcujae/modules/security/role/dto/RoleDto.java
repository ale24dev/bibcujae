package cujae.edu.cu.bibcujae.modules.security.role.dto;

import lombok.Data;

@Data
public class RoleDto {
	/*
	 * Identificador del rol
	 */
	private Long idRole;

	/*
	 * Nombre del rol
	 */
	private String name;

	public RoleDto(Long idRole, String name, String description) {
		this.idRole = idRole;
		this.name = name;
	}

	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
