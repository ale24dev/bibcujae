package cujae.edu.cu.bibcujae.modules.security.auth.dto;

import lombok.Data;

/*
 * Clase encargada de gestionar a los usuarios.
 */
@Data
public class LoginRequestDto {

    /*
     * Nombre de usuario.
     */
    private String username;
    /*
     * Contraseña del usuario.
     */
    private String password;

    public LoginRequestDto() {
        super();
    }

    public LoginRequestDto(String username, String password) {
        super();
        this.username = username;
        this.password = password;
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
