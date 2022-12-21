package cujae.edu.cu.bibcujae.modules.security.user.entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import cujae.edu.cu.bibcujae.modules.security.user_role.entity.UserRoleEntity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/*
 * Clase referencia de la tabla usuarios de la Base de Datos.
 */
@Entity
@javax.persistence.Table(name = "\"xuser\"")
public class UserEntity {
    /*
     * Identificación del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    /*
     * Nombre de usuario.
     */
    @Column(name = "username")
    private String username;

    /*
     * Contraseña del usuario
     */
    @Column(name = "password")
    private String password;

    /*
     * Nombre completo del usuario
     */
    @Column(name = "fullname")
    private String fullname;

    /*
     * Email del usuario
     */
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    Set<UserRoleEntity> userRole;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getIdUser() {
        return id_user;
    }

    public void setIdUser(Long idUser) {
        this.id_user = idUser;
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
        return "UserEntity [id_user=" + id_user + ", username=" + username + ", password=" + password + ", userRole="
                + userRole + "]";
    }

}