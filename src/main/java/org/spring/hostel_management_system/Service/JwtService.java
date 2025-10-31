package org.spring.hostel_management_system.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.spring.hostel_management_system.Model.Role;
import org.spring.hostel_management_system.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final String secret_key;
    private final long expiration_value;

    public JwtService(@Value("${jwt.secret}") String secret_key,@Value("${jwt.expiration}") long expiration_value) {
        this.secret_key = secret_key;
        this.expiration_value = expiration_value;
    }

    public String generateToken(String email, Set<Role> roles) {
         return JWT.create()
                 .withSubject(email)
                 .withClaim("roles",roles.stream().map(Enum::name).collect(Collectors.toList()))
                 .withIssuedAt(new Date(System.currentTimeMillis()))
                 .withExpiresAt(new Date(System.currentTimeMillis()+expiration_value))
                 .sign(Algorithm.HMAC256(secret_key));
    }
    public boolean validateToken(String token){
        try{
            JWTVerifier verifier=JWT.require(Algorithm.HMAC256(secret_key)).build();
            verifier.verify(token);
            return true;
        }
        catch (JWTVerificationException e){
            return false;
        }
    }

    public String extractEmail(String token){
        JWTVerifier verifier=JWT.require(Algorithm.HMAC256(secret_key)).build();
        DecodedJWT decodedJWT=verifier.verify(token);
        return decodedJWT.getSubject();
    }

    public Set<Role> extractRoles(String token){
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(secret_key)).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        return decodedJWT
                .getClaim("roles")
                .asList(String.class)
                .stream()
                .map(Role::valueOf)
                .collect(Collectors.toSet());
    }

}
