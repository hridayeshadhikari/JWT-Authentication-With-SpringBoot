package com.jwtauthentication.repository;
import com.jwtauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Integer> {

}
