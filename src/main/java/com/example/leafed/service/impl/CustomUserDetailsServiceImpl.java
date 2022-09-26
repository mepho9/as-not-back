package com.example.leafed.service.impl;

import com.example.leafed.entities.UserAuthentification;
import com.example.leafed.form.userauthentification.UserAuthCreateForm;
import com.example.leafed.repository.MemberRepository;
import com.example.leafed.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    private final MemberRepository memberRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder encoder, MemberRepository memberRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.memberRepository = memberRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("connexion impossible"));
    }
    public void create(UserAuthCreateForm toCreate){
        UserAuthentification userAuthentification = toCreate.toEntity();

        userAuthentification.setPassword(encoder.encode(userAuthentification.getPassword()));
        userRepository.save(userAuthentification);

    }
}
