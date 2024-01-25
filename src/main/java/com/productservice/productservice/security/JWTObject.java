package com.productservice.productservice.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JWTObject {
    //this is a DTO object
    private String Email;
    private Long userId;
    private Date expiryAt;
    private Date createdAt;
    private List<Role> roles;
}
