package com.example.leafed.controller;

import com.example.leafed.dto.MemberDTO;
import com.example.leafed.form.member.InsertMember;
import com.example.leafed.form.member.UpdateMember;
import com.example.leafed.mapper.MemberMapper;
import com.example.leafed.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/member")
@RestController
public class MemberController {

    private final MemberService memberService;

    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping("/insert")
    public MemberDTO insert(@RequestBody InsertMember toInsert){
        return this.memberService.create(toInsert);
    }


    @GetMapping("/{id:[0-9]+}")
    public MemberDTO getOne(@PathVariable Long id){
        return this.memberService.getOne(id);
    }

    @GetMapping("/all")
    public List<MemberDTO> getAll(){
        return this.memberService.getAll();
    }

    @PutMapping("/{id}")
    public MemberDTO update(@PathVariable Long id, @RequestBody UpdateMember toUpdate){
        return memberService.update(id,toUpdate);
    }
    @DeleteMapping("/{id:[0-9]+}")
    public MemberDTO delete(@PathVariable Long id){
        return this.memberService.delete(id);
    }
}
