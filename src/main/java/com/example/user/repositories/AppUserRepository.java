package com.example.user.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.user.models.AppUser;


@Repository
public interface AppUserRepository extends Dao<AppUser> {
    
    Optional<AppUser> findByEmail(String email);
}