/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.controller;

import fon.nstproject.config.TokenProvider;
import fon.nstproject.domain.User;
import fon.nstproject.dto.JwtDto;
import fon.nstproject.dto.SignInUserDto;
import fon.nstproject.dto.SignUpUserDto;
import fon.nstproject.service.impl.AuthServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("nst/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthServiceImpl authService;
    @Autowired
    private TokenProvider tokenService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpUserDto data) throws Exception {
        authService.signUp(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<JwtDto> signIn(@Valid @RequestBody SignInUserDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenService.generateAccessToken((User) authUser.getPrincipal());
        return ResponseEntity.ok(new JwtDto(accessToken));
    }
}
