package com.example.leafed.service;

import com.example.leafed.dto.MemberDTO;
import com.example.leafed.entities.Member;
import com.example.leafed.form.member.InsertMember;
import com.example.leafed.form.member.UpdateMember;

public interface MemberService extends CrudService<MemberDTO, Long, InsertMember, UpdateMember>{

    MemberDTO update(Long id, UpdateMember toUpdate);


}
