package com.example.leafed.dto;


import lombok.*;

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

    private List<PublicationDTO> publications;

    private List<CommentDTO> comments;


}
