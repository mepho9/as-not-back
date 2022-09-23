package com.example.leafed.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class PossibilityDTO {

    private Long possibilityId;

    private MemberDTO member;

    private PublicationDTO publication;


}
