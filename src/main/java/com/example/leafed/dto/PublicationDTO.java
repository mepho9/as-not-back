package com.example.leafed.dto;

import com.example.leafed.entities.Member;
import com.example.leafed.entities.Possibility;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class PublicationDTO {

    private Long publicationId;

    private String publicationText;

    private MemberDTO member;

    private List<Long> possibilities;

    private List<Long> comments;


}
