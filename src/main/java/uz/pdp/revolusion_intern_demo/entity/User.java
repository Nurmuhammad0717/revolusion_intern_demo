package uz.pdp.revolusion_intern_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.revolusion_intern_demo.entity.templates.AbsLongEntity;
import uz.pdp.revolusion_intern_demo.enums.RoleEnum;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "users")
public class User extends AbsLongEntity implements UserDetails {
    @Column(unique = true)
    private String email;

    private String password;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    private boolean enable;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String Role = "ROLE_";
        return List.of(new SimpleGrantedAuthority(Role+role.name()));
    }

    @Override
    public String getUsername() {
        return email;
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
        return enable;
    }
}