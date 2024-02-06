package com.jwtauthentication.Request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class LoginRequest {

    private String username;
    private String password;
}
