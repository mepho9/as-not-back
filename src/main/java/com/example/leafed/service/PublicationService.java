package com.example.leafed.service;

import com.example.leafed.dto.PublicationDTO;
import com.example.leafed.form.member.UpdateMember;
import com.example.leafed.form.publication.InsertPublication;
import com.example.leafed.form.publication.UpdatePublication;

import java.util.List;

public interface PublicationService extends CrudService<PublicationDTO, Long, InsertPublication, UpdatePublication> {

    PublicationDTO update(Long id, UpdatePublication toUpdate);




}
