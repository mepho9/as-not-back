package com.example.leafed.dto;

import com.example.leafed.entities.Member;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CommentDTO {

    private Long commentId;

    private String comment;

    private MemberDTO member;

    private PublicationDTO publication;
}
