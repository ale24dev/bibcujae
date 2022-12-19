package cujae.edu.cu.bibcujae.modules.security.auth.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cujae.edu.cu.bibcujae.modules.security.user.dto.UserDto;

public class UserPrincipal implements UserDetails {
    private Long id;
    private String password;
    private boolean active;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String password, boolean active,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.password = password;
        this.active = active;
        this.authorities = authorities;
    }

    public static UserPrincipal create(UserDto user) {
        List<GrantedAuthority> authorities;
        try {
            Collection<String> roleNames = user.getRoles().stream().map(role -> role.getName())
                    .collect(Collectors.toList());
            authorities = AuthorityUtils.createAuthorityList(roleNames.toArray(new String[0]));

        } catch (Exception e) {
            authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        }
        return new UserPrincipal(
                user.getId(),
                user.getPassword(),
                true,
                authorities);
    }

    public static UserPrincipal create(UserDto user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        return userPrincipal;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
