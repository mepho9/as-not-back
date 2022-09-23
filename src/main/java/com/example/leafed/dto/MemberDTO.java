package com.example.leafed.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class MemberDTO {

    private Long id;

    private String pseudo;

    private String country;

    private LocalDate birthDate;

    private List<Long> publications;

    private List<Long> comments;

}
