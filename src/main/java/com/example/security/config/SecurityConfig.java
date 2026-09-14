package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(
                "/",
                "/login",
                "/api/v1/auth/login",
                "/api/v1/admin/merchants/ui-kyc",
                "/api/v1/admin/merchants/{merchantId}/kyc",
                
                "/api/v1/admin/merchants/*/approve",
                "/api/v1/admin/merchants/ui-approve",
                
                "/api/v1/merchants/register",
                "/api/v1/merchants/ui-register"
            ).permitAll()
            .anyRequest().authenticated();

        return http.build();
    }
}
