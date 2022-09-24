package com.example.leafed.controller;

import com.example.leafed.dto.PublicationDTO;
import com.example.leafed.form.publication.InsertPublication;
import com.example.leafed.form.publication.UpdatePublication;
import com.example.leafed.mapper.PublicationMapper;
import com.example.leafed.service.PublicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/publication")
@RestController
public class PublicationController {

    private final PublicationService publicationService;
    private final PublicationMapper publicationMapper;

    public PublicationController(PublicationService publicationService, PublicationMapper publicationMapper) {
        this.publicationService = publicationService;
        this.publicationMapper = publicationMapper;
    }

    @PostMapping("/insert")
    public PublicationDTO insert(@RequestBody InsertPublication toInsert){
        return this.publicationService.create(toInsert);
    }

    @GetMapping("/{id:[0-9]+}")
    public PublicationDTO getOne(@PathVariable Long id){
        return this.publicationService.getOne(id);
    }
    @GetMapping("/all")
    public List<PublicationDTO> getAll(){
        return this.publicationService.getAll();
    }

    @PutMapping("/{id}")
    public PublicationDTO update(@PathVariable Long id, @RequestBody UpdatePublication toUpdate){
        return this.publicationService.update(id,toUpdate);
    }

    @DeleteMapping("/{id:[0-9]+}")
    public PublicationDTO delete(@PathVariable Long id){
        return this.publicationService.delete(id);
    }

}
