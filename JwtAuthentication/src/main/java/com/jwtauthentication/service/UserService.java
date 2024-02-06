package com.jwtauthentication.service;
import com.jwtauthentication.model.User;
import com.jwtauthentication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserService {

    List<User> getAll();
}
