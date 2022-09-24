package com.example.leafed.controller;

import com.example.leafed.dto.MemberDTO;
import com.example.leafed.dto.PossibilityDTO;
import com.example.leafed.form.member.InsertMember;
import com.example.leafed.form.member.UpdateMember;
import com.example.leafed.form.possibility.InsertPossibility;
import com.example.leafed.form.possibility.UpdatePossibility;
import com.example.leafed.mapper.PossibilityMapper;
import com.example.leafed.service.PossibilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/possibility")
@RestController
public class PossibilityController {

    private final PossibilityService possibilityService;


    private final PossibilityMapper possibilityMapper;

    public PossibilityController(PossibilityService possibilityService, PossibilityMapper possibilityMapper) {
        this.possibilityService = possibilityService;
        this.possibilityMapper = possibilityMapper;
    }

    @PostMapping("/insert")
    public PossibilityDTO insert(@RequestBody InsertPossibility toInsert){
        return this.possibilityService.create(toInsert);
    }


    @GetMapping("/{id:[0-9]+}")
    public PossibilityDTO getOne(@PathVariable Long id){
        return this.possibilityService.getOne(id);
    }

    @GetMapping("/all")
    public List<PossibilityDTO> getAll(){
        return this.possibilityService.getAll();
    }

    @PutMapping("/{id}")
    public PossibilityDTO update(@PathVariable Long id, @RequestBody UpdatePossibility toUpdate){
        return possibilityService.update(id,toUpdate);
    }
    @DeleteMapping("/{id:[0-9]+}")
    public PossibilityDTO delete(@PathVariable Long id){
        return this.possibilityService.delete(id);
    }

}
