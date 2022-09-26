package com.example.leafed.controller;


import com.example.leafed.form.userauthentification.LoginForm;
import com.example.leafed.form.userauthentification.UserAuthCreateForm;
import com.example.leafed.service.impl.CustomUserDetailsServiceImpl;
import com.example.leafed.service.impl.MemberServiceImpl;
import com.example.leafed.utils.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAuthController {
    private final CustomUserDetailsServiceImpl service;
    private final AuthenticationManager authManager;


    private final JwtProvider jwtProvider;


    public UserAuthController(CustomUserDetailsServiceImpl service, AuthenticationManager authManager, MemberServiceImpl memberService, JwtProvider jwtProvider) {
        this.service = service;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public void createUser(@RequestBody UserAuthCreateForm form){
        service.create(form);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginForm form){
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(),form.getPassword()));
        return jwtProvider.createToken(auth);

    }
}
