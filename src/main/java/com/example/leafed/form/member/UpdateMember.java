package com.example.leafed.form.member;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class UpdateMember {

    private String pseudo;

    private String country;

    private LocalDate birthDate;

    private List<Long> publicationsId;

    private List<Long> commentsId;



}
