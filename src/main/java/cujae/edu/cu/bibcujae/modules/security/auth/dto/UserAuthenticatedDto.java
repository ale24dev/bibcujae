package cujae.edu.cu.bibcujae.modules.security.auth.dto;

/*
 * Clase encargada de gestionar a los usuarios.
 */
public class UserAuthenticatedDto {

    /*
     * Nombre de usuario.
     */
    private String username;
    /*
     * Contraseña del usuario.
     */
    private String password;

    /*
     * Token del usuario.
     */
    private String token;

    public UserAuthenticatedDto() {
        super();
    }

    public UserAuthenticatedDto(String username, String password, String token) {
        super();
        this.username = username;
        this.password = password;
        this.token = token;
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

}
