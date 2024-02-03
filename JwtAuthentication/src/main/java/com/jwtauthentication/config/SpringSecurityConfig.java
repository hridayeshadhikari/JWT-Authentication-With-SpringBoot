package com.jwtauthentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SpringSecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails adminUser= User.builder().username("Hridayesh")
//                .password(passwordEncoder().encode("harry"))
//                .roles("ADMIN")
//                .build();
//        UserDetails normalUser= User.builder().username("Harshit")
//                .password(passwordEncoder().encode("harry"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(adminUser,normalUser);}


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


}
