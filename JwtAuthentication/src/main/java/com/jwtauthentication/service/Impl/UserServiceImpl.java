package com.jwtauthentication.service.Impl;

import com.jwtauthentication.model.User;
import com.jwtauthentication.repository.UserRepository;
import com.jwtauthentication.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
