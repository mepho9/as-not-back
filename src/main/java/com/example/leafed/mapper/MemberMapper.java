package com.example.leafed.mapper;

import com.example.leafed.dto.MemberDTO;
import com.example.leafed.entities.Comment;
import com.example.leafed.entities.Member;
import com.example.leafed.entities.Publication;
import com.example.leafed.form.member.InsertMember;
import com.example.leafed.form.member.UpdateMember;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberMapper {


    @Transactional
    public MemberDTO toDto(Member member){

        if(member==null){
            return null;
        }
        List<Long> publicationsId = null;
        List<Long> commentsId = null;

        if(member.getPublications() != null){
            publicationsId = member
                    .getPublications()
                    .stream()
                    .map(Publication::getPublicationId)
                    .collect(Collectors.toList());
        }

        if(member.getMemberComments() != null ){
            commentsId = member
                    .getMemberComments()
                    .stream()
                    .map(Comment::getId)
                    .collect(Collectors.toList());
        }

        return MemberDTO.builder()
                .id(member.getId())
                .pseudo(member.getPseudo())
                .country(member.getCountry())
                .birthDate(member.getBirthDate())
                .publications(publicationsId)
                .comments(commentsId)
                .build();
    }

    public Member toEntity(InsertMember toInsert){
        if(toInsert==null){
            return null;
        }
        else{
            Member member = new Member();

            member.setPseudo(toInsert.getPseudo());
            member.setCountry(toInsert.getCountry());
            member.setBirthDate(toInsert.getBirthDate());

            return member;
        }
    }

    public Member toEntityU(UpdateMember toUpdate){

        if(toUpdate == null){
            return null;
        }

        Member member = new Member();

        member.setPseudo(toUpdate.getPseudo());
        member.setCountry(toUpdate.getCountry());
        member.setBirthDate(toUpdate.getBirthDate());

        return member;


    }
}
