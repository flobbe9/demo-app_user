package com.example.user.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/error")
public class HttpStatusHandler {
    
    @GetMapping
    public String handle(HttpServletRequest request) {

        // Object status = (request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));

        // return status.orElseThrow(() -> 
        //     new IllegalStateException("Failed to handle http status error."));
    }
}