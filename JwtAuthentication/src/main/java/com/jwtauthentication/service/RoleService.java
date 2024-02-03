package com.jwtauthentication.service;

import com.jwtauthentication.model.Role;
import com.jwtauthentication.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role createNewRole(){
        return  roleRepository.c;
    }

}
