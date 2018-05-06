package com.example.jwt.security;

import com.example.jwt.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secret = "partyEasy";

    public JwtUser validate(String token){

        JwtUser user = null;
        try{
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();


             user = new JwtUser();
            user.setUserName(body.getSubject());
            user.setUserId(Long.parseLong((String) body.get("userId")));
            user.setRole((String) body.get("role"));
        } catch (Exception e){
            System.out.println(e);
        }


        return user;
    }
}
