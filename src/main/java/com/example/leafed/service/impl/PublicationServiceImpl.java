package com.example.leafed.service.impl;

import com.example.leafed.dto.PublicationDTO;
import com.example.leafed.entities.Publication;
import com.example.leafed.form.member.UpdateMember;
import com.example.leafed.form.publication.InsertPublication;
import com.example.leafed.form.publication.UpdatePublication;
import com.example.leafed.mapper.PublicationMapper;
import com.example.leafed.repository.PublicationRepository;
import com.example.leafed.service.PublicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;
    private final PublicationMapper publicationMapper;



    public PublicationServiceImpl(PublicationRepository publicationRepository, PublicationMapper publicationMapper) {
        this.publicationRepository = publicationRepository;
        this.publicationMapper = publicationMapper;
    }

    @Override
    public PublicationDTO create(InsertPublication toInsert) {
        if(toInsert == null){
            throw new IllegalArgumentException("inserted Publication cannot be null");
        }
        Publication publication = publicationMapper.toEntity(toInsert);
        publication = publicationRepository.save(publication);

        return publicationMapper.toDto(publication);
    }



    @Override
    public PublicationDTO getOne(Long id) {
        return publicationMapper
                .toDto(this.publicationRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public List<PublicationDTO> getAll() {
        return this.publicationRepository.findAll()
                .stream()
                .map(publicationMapper::toDto)
                .toList();
    }

    @Override
    public PublicationDTO update(Long id, UpdatePublication toUpdate) {

        if(toUpdate == null || id == null){
            throw new IllegalArgumentException("publication or id doesn't exist");
        }
        if(!publicationRepository.existsById(id)){
            throw new RuntimeException();
        }

        Publication publication = publicationMapper.toEntityU(toUpdate);
        publication.setPublicationId(id);

        return publicationMapper.toDto(publicationRepository.save(publication));
    }
    @Override
    public PublicationDTO delete(Long id) {

        Publication publication =
                publicationRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new);

        this.publicationRepository.delete(publication);
        publication.setPublicationId(null);

        return publicationMapper.toDto(publication);
    }


}
