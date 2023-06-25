package com.example.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Configuration class to authentiacate requests.
 * 
 * @since 0.0.1
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity // for @PreAuthorize
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf
                .disable())

			.authorizeHttpRequests(authorize -> authorize
                .anyRequest()
                    .permitAll())

            .formLogin(formLogin -> formLogin
                .defaultSuccessUrl("https://demo-ui-do4dkoej7q-ew.a.run.app", false)
                .loginProcessingUrl("/api/user/login") // has to be the same as post action in login form and use thymeleaf
                .loginPage("http://localhost:3000/login"));

        return http.build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        
        return new BCryptPasswordEncoder(10);
    }
}