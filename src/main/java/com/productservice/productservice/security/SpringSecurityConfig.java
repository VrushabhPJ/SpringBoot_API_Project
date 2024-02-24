package com.productservice.productservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        //.requestMatchers("/products").hasAuthority("admin")
                        .anyRequest().permitAll()
                        //.requestMatchers("/getProducts").permitAll()
//                        .anyRequest().permitAll()
                )
                .csrf().disable()
                .cors().disable()
//                 Form login handles the redirect to the login page from the
//                 authorization server filter chain
                .formLogin(withDefaults())
                .httpBasic(withDefaults());

        return http.build();
    }
}