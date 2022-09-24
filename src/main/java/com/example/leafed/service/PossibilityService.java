package com.example.leafed.service;

import com.example.leafed.dto.CommentDTO;
import com.example.leafed.dto.PossibilityDTO;
import com.example.leafed.form.comment.InsertComment;
import com.example.leafed.form.comment.UpdateComment;
import com.example.leafed.form.possibility.InsertPossibility;
import com.example.leafed.form.possibility.UpdatePossibility;

public interface PossibilityService extends CrudService<PossibilityDTO, Long, InsertPossibility, UpdatePossibility> {
    PossibilityDTO update(Long id, UpdatePossibility toUpdate);
}
