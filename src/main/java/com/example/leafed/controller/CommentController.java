package com.example.leafed.controller;

import com.example.leafed.dto.CommentDTO;
import com.example.leafed.dto.MemberDTO;
import com.example.leafed.form.comment.InsertComment;
import com.example.leafed.form.comment.UpdateComment;
import com.example.leafed.form.member.InsertMember;
import com.example.leafed.form.member.UpdateMember;
import com.example.leafed.mapper.CommentMapper;
import com.example.leafed.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }
    @PostMapping("/insert")
    public CommentDTO insert(@RequestBody InsertComment toInsert){
        return this.commentService.create(toInsert);
    }


    @GetMapping("/{id:[0-9]+}")
    public CommentDTO getOne(@PathVariable Long id){
        return this.commentService.getOne(id);
    }

    @GetMapping("/all")
    public List<CommentDTO> getAll(){
        return this.commentService.getAll();
    }

    @PutMapping("/{id}")
    public CommentDTO update(@PathVariable Long id, @RequestBody UpdateComment toUpdate){
        return commentService.update(id,toUpdate);
    }
    @DeleteMapping("/{id:[0-9]+}")
    public CommentDTO delete(@PathVariable Long id){
        return this.commentService.delete(id);
    }

}
