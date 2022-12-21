package cujae.edu.cu.bibcujae.modules.security.auth.dto;

import java.util.List;

import cujae.edu.cu.bibcujae.modules.security.role.dto.RoleDto;

public class UserAuthenticatedDto {
    private Long id;
    private String username;
    private String password;
    private List<RoleDto> roles;
    private String token;

    public UserAuthenticatedDto() {
        super();
    }

    public UserAuthenticatedDto(Long id, String username, String password,
            List<RoleDto> roles, String token) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserAuthenticatedDto [id=" + id + ", username=" + username + ", password=" + password + ", roles="
                + roles + ", token=" + token + "]";
    }

}
