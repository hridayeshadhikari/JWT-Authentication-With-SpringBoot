package com.jwtauthentication.controller;

import com.jwtauthentication.model.User;
import com.jwtauthentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/home")
    public String homePage(){
        return "this is homePage";
    }

    private UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAll();
    }
}
