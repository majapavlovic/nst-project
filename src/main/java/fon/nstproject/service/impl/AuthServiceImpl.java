/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.service.impl;

import fon.nstproject.dto.SignUpUserDto;
import fon.nstproject.repository.UserRepository;
import fon.nstproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class AuthServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = repository.findByUsername(username);
        return user;
    }

    public UserDetails signUp(SignUpUserDto data) throws Exception {
        if (repository.findByUsername(data.username()) != null) {
            throw new Exception("User with that username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), encryptedPassword, data.role());
        return repository.save(newUser);
    }
    
    public void updateUserData(User user) throws Exception {
        repository.save(user);
    }

}
