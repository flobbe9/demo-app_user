package com.example.user.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum AppUserRole {
    USER,
    ADMIN;


    public Collection<? extends GrantedAuthority> getGrantedAuthorities() {

        return List.of(new SimpleGrantedAuthority("ROLE_" + this.name()));
    }
}