package com.example.leafed.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@Slf4j
@Component
public class JwtProvider {

    private final JwtProperties properties;
    private final UserDetailsService service;

    public JwtProvider(JwtProperties properties, UserDetailsService service) {
        this.properties = properties;
        this.service = service;
    }

    public String createToken(Authentication auth){
        return JWT.create()
                .withExpiresAt(Instant.now().plusSeconds(properties.getExpiresAt()))
                .withSubject(auth.getName())
                .withClaim(
                        "roles",
                        auth.getAuthorities().stream()
                                .map(GrantedAuthority::getAuthority)
                                .toList()
                )
                .sign(Algorithm.HMAC512(properties.getSecret()));
    }

    public String extractToken(HttpServletRequest request){
        String authHeader = request.getHeader(properties.getHeaderKey());
        return authHeader == null ? null : authHeader.replace(properties.getHeaderPrefix(),"");
    }

    public boolean validate(String token){
        try{
            JWT.require(Algorithm.HMAC512(properties.getSecret()))
                    .acceptExpiresAt(properties.getExpiresAt())
                    .build().verify(token);

            return true;
        }
        catch (JWTVerificationException ex){
            log.warn(ex.getMessage());
            return false;
        }

    }

    public Authentication generateAuth(String token){
        DecodedJWT decodedJWT = JWT.decode(token);

        UserDetails user = service.loadUserByUsername(decodedJWT.getSubject());

        return new UsernamePasswordAuthenticationToken(
                decodedJWT.getSubject(),
                null,
                user.getAuthorities()
        );
    }
}
