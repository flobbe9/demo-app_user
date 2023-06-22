package com.example.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
// @EnableWebMvc
public class SecurityConfig 
    // implements WebMvcConfigurer
    {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf
                .disable()
            )

			.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.GET, "/api/user", "/api/user/addTestUser")
                    .permitAll()
                .requestMatchers(HttpMethod.POST, "/api/user/save")
                    .permitAll()
                .anyRequest()
                    .hasRole("USER")
            )

            .formLogin(formLogin -> formLogin
                // .failureUrl("/api/user/login")
                .loginPage("http://locahost:4000/api/user/login")
                .permitAll());

        return http.build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        
        return new BCryptPasswordEncoder(10);
    }
}