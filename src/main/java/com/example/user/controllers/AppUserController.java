package com.example.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.models.AppUser;
import com.example.user.models.AppUserRole;
import com.example.user.services.AppUserService;

import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/api/user")
@Log4j2
public class AppUserController {
    
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/save")
    public ResponseEntity<AppUser> save(@RequestBody AppUser appUser) {

        return ResponseEntity.ok().body(appUserService.save(appUser));
    }


    @GetMapping("/viewUser")
    public String viewUser() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return "Currently logged in: " + username;
    }


    @GetMapping("/test")
    public String test() {

        return "Test. \n This page should have a USER restriction.";
    }


    @GetMapping("/addTestUser")
    public ResponseEntity<AppUser> addTestUser() {

        log.info("Saving test user.");

        AppUser appUser = new AppUser("Florin", 
                                      "Schikarski", 
                                      "florin735@live.com", 
                                      "password", 
                                      AppUserRole.USER, 
                                      true, 
                                      true, 
                                      true, 
                                      true);

        // encrypt password
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        
        appUserService.save(appUser);

        return ResponseEntity.ok(appUser);
    }
}