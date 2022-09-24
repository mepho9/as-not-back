package com.example.leafed.mapper;


import com.example.leafed.dto.PublicationDTO;
import com.example.leafed.entities.Comment;
import com.example.leafed.entities.Possibility;
import com.example.leafed.entities.Publication;
import com.example.leafed.form.publication.InsertPublication;
import com.example.leafed.form.publication.UpdatePublication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PublicationMapper {

    @Transactional
    public PublicationDTO toDto(Publication publication){
        if(publication == null){
            return null;
        }
        List<Long> possibilitiesId = null;
        List<Long> commentsId = null;

        if(publication.getPossibilities() != null){
            possibilitiesId = publication
                    .getPossibilities()
                    .stream()
                    .map(Possibility::getPossibilityId)
                    .toList();
        }

        if(publication.getComments() != null){
            commentsId = publication
                    .getComments()
                    .stream()
                    .map(Comment::getId)
                    .toList();
        }

        return PublicationDTO.builder()
                .publicationId(publication.getPublicationId())
                .publicationText(publication.getPublicationText())
                .member(publication.getMemberPublication())
                .possibilities(possibilitiesId)
                .comments(commentsId)
                .build();
    }


    public Publication toEntity(InsertPublication toInsert){
        if(toInsert == null){
            return null;
        }
        else{
            Publication publication = new Publication();

            publication.setPublicationText(toInsert.getPublicationText());
            //publication.setMemberPublication(toInsert.getMemberPublicationID());

            return publication;
        }
    }

    public Publication toEntityU(UpdatePublication toUpdate){
        if(toUpdate == null){
            return null;
        }
        Publication publication = new Publication();

        publication.setPublicationText(toUpdate.getPublicationText());
        //publication.setMemberPublication(toUpdate());

        return publication;
    }
}
