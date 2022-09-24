package com.example.leafed.form.publication;

import com.example.leafed.dto.MemberDTO;
import com.example.leafed.entities.Member;
import com.example.leafed.form.member.InsertMember;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InsertPublication {

    private String publicationText;

    //private Long memberPublicationID;

    //private List<Long> possibilitiesId = new ArrayList<>();

    //private List<Long> commentsId = new ArrayList<>();
}
