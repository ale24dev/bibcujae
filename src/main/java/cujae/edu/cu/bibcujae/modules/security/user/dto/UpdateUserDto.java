package cujae.edu.cu.bibcujae.modules.security.user.dto;

/*
 * Clase encargada de gestionar los cambios de información un usuario.
 */
public class UpdateUserDto {

    /*
     * Identificación del usuario.
     */
    private Long id;
    /*
     * Nombre del usuario.
     */

    private String username;

    /*
     * Contraseña del usuario.
     */
    private String password;

    /*
	 * Nombre completo del usuario.
	 */
	private String fullname;

	/*
	 * Email de usuario.
	 */
	private String email;

    public UpdateUserDto() {
        super();
    }

    public UpdateUserDto(String username, String password) {
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

    public Long getId() {
        return id;
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
        return "UpdateUserDto [id=" + id + ", username=" + username + ", password=" + password + "]";
    }


    
}
