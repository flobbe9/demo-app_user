package com.example.user.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/error")
public class HttpStatusController implements ErrorController {
    
    // TODO: does not seem like the best option because repetitive
    @GetMapping
    public String handleGet(HttpServletRequest request) {

        return handle(request);
    }


    @PostMapping
    public String handlePost(HttpServletRequest request) {

        return handle(request);
    }


    private String handle(HttpServletRequest request) {

        Object status = (request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        
        if (status != null)  
            return status.toString();

        return "500";
    }
}