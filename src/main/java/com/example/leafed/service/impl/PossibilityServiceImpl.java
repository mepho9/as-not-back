package com.example.leafed.service.impl;

import com.example.leafed.dto.PossibilityDTO;
import com.example.leafed.entities.Possibility;
import com.example.leafed.entities.Publication;
import com.example.leafed.form.possibility.InsertPossibility;
import com.example.leafed.form.possibility.UpdatePossibility;
import com.example.leafed.mapper.PossibilityMapper;
import com.example.leafed.repository.PossibilityRepository;
import com.example.leafed.service.PossibilityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PossibilityServiceImpl implements PossibilityService {
    private final PossibilityRepository possibilityRepository;
    private final PossibilityMapper possibilityMapper;

    public PossibilityServiceImpl(PossibilityRepository possibilityRepository, PossibilityMapper possibilityMapper) {
        this.possibilityRepository = possibilityRepository;
        this.possibilityMapper = possibilityMapper;
    }


    @Override
    public PossibilityDTO create(InsertPossibility toInsert) {
        if(toInsert == null){
            throw new IllegalArgumentException("inserted Publication cannot be null");
        }
        Possibility possibility = possibilityMapper.toEntity(toInsert);
        possibility = possibilityRepository.save(possibility);

        return possibilityMapper.toDto(possibility);
    }

    @Override
    public PossibilityDTO getOne(Long id) {
        return possibilityMapper
                .toDto(this.possibilityRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new));    }

    @Override
    public List<PossibilityDTO> getAll() {
        return this.possibilityRepository.findAll()
                .stream()
                .map(possibilityMapper::toDto)
                .toList();    }

    @Override
    public PossibilityDTO update(Long id, UpdatePossibility toUpdate) {
        if(toUpdate == null || id == null){
            throw new IllegalArgumentException("publication or id doesn't exist");
        }
        if(!possibilityRepository.existsById(id)){
            throw new RuntimeException();
        }

        Possibility possibility = possibilityMapper.toEntityU(toUpdate);
        possibility.setPossibilityId(id);

        return possibilityMapper.toDto(possibilityRepository.save(possibility));    }
    @Override
    public PossibilityDTO delete(Long id) {
        Possibility possibility =
                possibilityRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new);

        this.possibilityRepository.delete(possibility);
        possibility.setPossibilityId(null);

        return possibilityMapper.toDto(possibility);    }


}
