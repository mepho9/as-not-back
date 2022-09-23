package com.example.leafed.service.impl;

import com.example.leafed.dto.MemberDTO;
import com.example.leafed.form.member.InsertMember;
import com.example.leafed.form.member.UpdateMember;
import com.example.leafed.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public MemberDTO create(InsertMember toInsert) {
        return null;
    }

    @Override
    public MemberDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<MemberDTO> getAll() {
        return null;
    }

    @Override
    public MemberDTO delete(Long id) {
        return null;
    }

    @Override
    public MemberDTO update(Long id, UpdateMember toUpdate) {
        return null;
    }
}
