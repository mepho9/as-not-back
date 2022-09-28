package com.example.leafed.form.userauthentification;

import com.example.leafed.entities.Member;
import com.example.leafed.entities.UserAuthentification;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAuthCreateForm {

    private String pseudo;
    private String country;
    private LocalDate birthDate;

    private String username;
    private String password;

    public Member toEntity(){

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setCountry(country);
        member.setPseudo(pseudo);
        member.setBirthDate(birthDate);


        return member;

    }
}
