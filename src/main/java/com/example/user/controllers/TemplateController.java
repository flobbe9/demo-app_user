package com.example.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/user")
public class TemplateController {
    
    @GetMapping
    public String index() {

        return "index";
    }


    @GetMapping("/login")
    public String login() {

        return "login";
    }
}