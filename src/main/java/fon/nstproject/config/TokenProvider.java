/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.nstproject.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import fon.nstproject.domain.User;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;


/**
 *
 * @author User
 */
@Service
public class TokenProvider {
   @Value("${security.jwt.token.secret-key}")
    private String JWT_SECRET;

    public String generateAccessToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("username", user.getUsername())
                .withExpiresAt(genAccessExpirationDate())  
                .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new JWTCreationException("Error while generating token", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                .build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("JWT EXPIRES AT: " + jwt.getExpiresAt());
            if (jwt.getExpiresAt().before(new Date())) {
                throw new JWTVerificationException("Token has expired");
            }
            
            return jwt.getSubject();
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Error while validating token", exception);
        }
    }

    private Instant genAccessExpirationDate() {
        return LocalDateTime.now().plusMinutes(30l).toInstant(ZoneOffset.UTC.of("+02:00"));  
    }
}
