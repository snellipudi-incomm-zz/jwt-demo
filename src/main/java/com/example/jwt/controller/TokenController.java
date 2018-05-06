package com.example.jwt.controller;

import com.example.jwt.model.JwtUser;
import com.example.jwt.security.JwtTokenGenerator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    private JwtTokenGenerator jwtTokenGenerator;

    public TokenController(JwtTokenGenerator jwtGenerator){
        this.jwtTokenGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final JwtUser user){

        return jwtTokenGenerator.generate(user);
    }
}
