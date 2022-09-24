package com.example.leafed.mapper;

import com.example.leafed.dto.CommentDTO;
import com.example.leafed.entities.Comment;
import com.example.leafed.form.comment.InsertComment;
import com.example.leafed.form.comment.UpdateComment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentMapper {


    @Transactional
    public CommentDTO toDto(Comment comment){
        if(comment == null){
            return null;
        }

        return CommentDTO.builder()
                .comment(comment.getComment())
                .build();
    }

    public Comment toEntity(InsertComment toInsert){
        if(toInsert==null){
            return null;
        }
        else{
            Comment comment = new Comment();

            comment.setComment(toInsert.getComment());

            return comment;
        }
    }
    public Comment toEntityU(UpdateComment toUpdate){
        if(toUpdate==null){
            return null;
        }
        Comment comment = new Comment();

        comment.setComment(toUpdate.getComment());

        return comment;
    }

}


