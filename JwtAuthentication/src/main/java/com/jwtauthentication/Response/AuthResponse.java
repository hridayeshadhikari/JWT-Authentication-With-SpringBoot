package com.jwtauthentication.Response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String token;
    private String message;

}

