package com.jwtauthentication.controller;

import com.jwtauthentication.model.Role;
import com.jwtauthentication.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Home {

    private final RoleService roleService;
    @GetMapping ("/welcome")
    public String home(){
        String text="Hello welcome this is home page";
        text+="this page is not accessed by unauthorized user";
        return text;
    }




}
