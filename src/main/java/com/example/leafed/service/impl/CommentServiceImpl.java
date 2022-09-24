package com.example.leafed.service.impl;

import com.example.leafed.dto.CommentDTO;
import com.example.leafed.entities.Comment;
import com.example.leafed.entities.Member;
import com.example.leafed.form.comment.InsertComment;
import com.example.leafed.form.comment.UpdateComment;
import com.example.leafed.mapper.CommentMapper;
import com.example.leafed.repository.CommentRepository;
import com.example.leafed.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }


    @Override
    public CommentDTO create(InsertComment toInsert) {
        if(toInsert == null){
            throw new IllegalArgumentException("inserted Member cannot be null");
        }

        Comment comment = commentMapper.toEntity(toInsert);
        comment = commentRepository.save(comment);

        return commentMapper.toDto(comment);
    }


    @Override
    public CommentDTO getOne(Long id) {
        return commentMapper
                .toDto(this.commentRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public List<CommentDTO> getAll() {
        return this.commentRepository.findAll()
                .stream()
                .map(commentMapper::toDto)
                .toList();
    }

    @Override
    public CommentDTO update(Long id, UpdateComment toUpdate) {
        if(toUpdate == null || id == null){
            throw new IllegalArgumentException("member or id doesn't exist");
        }
        if(!commentRepository.existsById(id)){
            throw new RuntimeException();
        }

        Comment comment = commentMapper.toEntityU(toUpdate);
        comment.setId(id);

        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public CommentDTO delete(Long id) {
        Comment comment =
                commentRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new);

        this.commentRepository.delete(comment);
        comment.setId(null);

        return commentMapper.toDto(comment);    }
}
