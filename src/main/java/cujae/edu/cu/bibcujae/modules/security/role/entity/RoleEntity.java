package cujae.edu.cu.bibcujae.modules.security.role.entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import cujae.edu.cu.bibcujae.modules.security.user_role.entity.UserRoleEntity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

/*
 * Clase referencia de la tabla role de la Base de Datos.
 */
@Data
@Entity
@javax.persistence.Table(name = "\"role\"")
public class RoleEntity {
    /*
     * Identificación del rol.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

    /*
     * Nombre del rol.
     */
    @Column(name = "name")
    private String name;

	@OneToMany(mappedBy = "role")
    Set<UserRoleEntity> userRole;


	public Long getIdRole() {
		return id_role;
	}

	public void setIdRole(Long idRole) {
		this.id_role = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
    
}