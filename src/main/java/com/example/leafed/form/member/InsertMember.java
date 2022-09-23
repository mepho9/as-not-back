package com.example.leafed.form.member;


import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class InsertMember {

    private String pseudo;

    private String country;

    private LocalDate birthDate;

    private List<Long> publicationsId = new ArrayList<>();

    private List<Long> commentsId = new ArrayList<>();

}
