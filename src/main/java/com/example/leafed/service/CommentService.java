package com.example.leafed.service;

import com.example.leafed.dto.CommentDTO;
import com.example.leafed.dto.PublicationDTO;
import com.example.leafed.form.comment.InsertComment;
import com.example.leafed.form.comment.UpdateComment;
import com.example.leafed.form.publication.InsertPublication;
import com.example.leafed.form.publication.UpdatePublication;

public interface CommentService extends CrudService<CommentDTO, Long, InsertComment, UpdateComment>{

    CommentDTO update(Long id, UpdateComment toUpdate);

}
