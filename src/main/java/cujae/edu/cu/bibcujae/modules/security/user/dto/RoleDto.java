package cujae.edu.cu.bibcujae.modules.security.user.dto;

import lombok.Data;

@Data
public class RoleDto {
	private Long id;
	private String roleName;
	private String description;
	
	public RoleDto(Long id, String roleName, String description) {
		this.id = id;
		this.roleName = roleName;
		this.description = description;
	}
	
	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
