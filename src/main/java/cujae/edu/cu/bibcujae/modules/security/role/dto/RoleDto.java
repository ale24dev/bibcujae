package cujae.edu.cu.bibcujae.modules.security.role.dto;

import lombok.Data;

@Data
public class RoleDto {
	/*
	 * Identificador del rol
	 */
	private Long id;

	/*
	 * Nombre del rol
	 */
	private String name;

	public RoleDto(Long id, String name, String description) {
		this.id = id;
		this.name = name;
	}

	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RoleDto [idRole=" + id + ", name=" + name + "]";
	}

}
