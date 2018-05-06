package com.example.jwt.security;

import com.example.jwt.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenGenerator {
    public String generate(JwtUser user) {

        Claims claims = Jwts.claims()
                .setSubject(user.getUserName());
        claims.put("userId", String.valueOf(user.getUserId()));
        claims.put("role", user.getRole());




            return     Jwts.builder()
                .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, "partyEasy")
                        .compact();



    }
}
