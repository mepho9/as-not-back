package com.example.leafed.service.impl;

import com.example.leafed.dto.MemberDTO;
import com.example.leafed.entities.Member;
import com.example.leafed.form.member.InsertMember;
import com.example.leafed.form.member.UpdateMember;
import com.example.leafed.mapper.MemberMapper;
import com.example.leafed.repository.MemberRepository;
import com.example.leafed.service.MemberService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }


    @Override
    public MemberDTO create(InsertMember toInsert) {
        if(toInsert == null){
            throw new IllegalArgumentException("inserted Member cannot be null");
        }

        Member member = memberMapper.toEntity(toInsert);
        member = memberRepository.save(member);

        return memberMapper.toDto(member);
    }

    @Override
    public MemberDTO getOne(Long id) {

        return memberMapper
                .toDto(this.memberRepository
                        .findById(id)
                        .orElseThrow
                        (RuntimeException::new));

    }

    @Override
    public List<MemberDTO> getAll() {
        return this.memberRepository.findAll()
                .stream()
                .map(memberMapper::toDto)
                .toList();
    }


    @Override
    @Transactional
    public MemberDTO update(Long id, UpdateMember toUpdate) {
        if(toUpdate == null || id == null){
            throw new IllegalArgumentException("child or id does not exist");
        }
        if(!memberRepository.existsById(id)){
            throw new RuntimeException();
        }

        Member member = memberMapper.toEntityU(toUpdate);
        member.setId(id);

        return memberMapper.toDto(memberRepository.save(member));
    }
    @Override
    @Transactional
    public MemberDTO delete(Long id)
    {
        Member member = memberRepository.findById(id)
                                        .orElseThrow(RuntimeException::new);
        this.memberRepository.delete(member);
        member.setId(null);

        return memberMapper.toDto(member);
    }


}
