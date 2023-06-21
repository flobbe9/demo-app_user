package com.example.user.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// TODO: add validation?
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser extends AbstractEntity implements UserDetails {

    private String firstName;
    
    private String lastName;

    private String email;

    private String password;

    private AppUserRole role;

    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;

    private boolean isEnabled = false;


    @Override
    public String toString() {

        return this.firstName;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return this.role.getGrantedAuthorities();
    }


    @Override
    public String getUsername() {

        return this.email;
    }


    @Override
    public boolean isAccountNonExpired() {

        return this.isAccountNonExpired;
    }


    @Override
    public boolean isAccountNonLocked() {

        return this.isAccountNonLocked;
    }


    @Override
    public boolean isCredentialsNonExpired() {

        return this.isCredentialsNonExpired;
    }


    @Override
    public boolean isEnabled() {

        return this.isEnabled;
    }


    @Override
    public String getPassword() {

        return this.password;
    }
}