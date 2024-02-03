package com.jwtauthentication.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {


    private String username;
    private String jwtToken;
}
