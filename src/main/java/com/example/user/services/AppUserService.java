package com.example.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.user.models.AppUser;
import com.example.user.repositories.AppUserRepository;


@Service
public class AppUserService extends AbstractService<AppUser> implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return (UserDetails) this.appUserRepository.findByEmail(username).orElseThrow(() ->
            new IllegalStateException("Could not find app user with email: " + username + "."));
    }


    public AppUser save(AppUser appUser) {

        return super.getDao().save(appUser);
    }


    public AppUser findByEmail(String email) {

        return this.appUserRepository.findByEmail(email).orElseThrow(() -> 
            new IllegalStateException("Could not find app user with email: " + email + "."));
    }


    public boolean exists(String email) {

        return this.appUserRepository.findByEmail(email).isPresent();
    }
}