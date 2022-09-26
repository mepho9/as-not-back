package com.example.leafed.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SmallMemberDTO {

    private Long id;

    private String pseudo;

    private String country;

    private LocalDate birthDate;
}
