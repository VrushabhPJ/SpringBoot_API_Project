package com.productservice.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidator {
    private RestTemplateBuilder restTemplateBuilder;

    TokenValidator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder= restTemplateBuilder;
    }
    /**
     *this method should call the user_service to validate the token
     * if token is valid then return the corresponding object class
     * else empty.
     * @param token
     * @return
     */
    public Optional<JWTObject> validateToken(String token){
        RestTemplate restTemplate=restTemplateBuilder.build();

        //Make an HTTP call to userserivce to call the validateToken method
        return Optional.empty();
    }
}
