package com.jwtauthentication.controller;
import com.jwtauthentication.Request.LoginRequest;
import com.jwtauthentication.Response.AuthResponse;
import com.jwtauthentication.model.User;
import com.jwtauthentication.repository.UserRepository;
import com.jwtauthentication.security.JwtProvider;
import com.jwtauthentication.service.CustomUserDetailsService;
import com.jwtauthentication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/register")
    public AuthResponse createNewUser(@RequestBody User user) throws Exception {

        User usExist=userRepository.findByEmail(user.getEmail());
        if (usExist!=null){
            throw new Exception("this email is associated with another account");
        }

        User createUser=new User();
        createUser.setEmail(user.getEmail());
        createUser.setPassword(passwordEncoder.encode(user.getPassword()));
        createUser.setFirstName(user.getFirstName());
        createUser.setLastName(user.getLastName());
        User saveUser=userRepository.save(createUser);

        Authentication authentication=new UsernamePasswordAuthenticationToken(saveUser.getEmail(),saveUser.getPassword());
        String token= JwtProvider.generateToken(authentication);
        AuthResponse res=new AuthResponse(token,"Registered Successfully");
        return res;
    }

    @PostMapping("/signin")
    public AuthResponse signin(@RequestBody LoginRequest loginRequest){
        Authentication authentication=authenticate(loginRequest.getEmail(),loginRequest.getPassword());
        String token= JwtProvider.generateToken(authentication);
        AuthResponse res=new AuthResponse(token,"Login Successful ");
        return res;
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails=customUserDetailsService.loadUserByUsername(email);
        if (userDetails==null){
            throw new BadCredentialsException("no user found with this username");
        }
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Incorrect Password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }

}
