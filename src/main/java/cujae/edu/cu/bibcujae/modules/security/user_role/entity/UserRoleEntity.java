package cujae.edu.cu.bibcujae.modules.security.user_role.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cujae.edu.cu.bibcujae.modules.security.role.entity.RoleEntity;
import cujae.edu.cu.bibcujae.modules.security.user.entity.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/*
 * Clase referencia de la tabla de relación entre role y user de la Base de Datos.
 */
@Entity
@javax.persistence.Table(name = "\"user_role\"")
public class UserRoleEntity {
    /*
     * Identificación del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserRole;

    /*
     * FK Identificador del usuario
     */
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    /*
     * FK Identificador del rol
     */
    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity role;

    public UserRoleEntity() {
    }

    public Long getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Long idUserRole) {
        this.idUserRole = idUserRole;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

}