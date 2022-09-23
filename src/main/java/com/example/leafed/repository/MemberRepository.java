package com.example.leafed.repository;

import com.example.leafed.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface MemberRepository extends JpaRepository<Member, Long> {
}
