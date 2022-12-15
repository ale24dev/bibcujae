package cujae.edu.cu.bibcujae.modules.security.user.entity;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

/*
 * Clase referencia de la tabla usuarios de la Base de Datos.
 */
@Data
@Entity
@javax.persistence.Table(name = "\"user\"")
public class UserEntity {
    /*
     * Identificación del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

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

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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