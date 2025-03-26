package com.kingmonkey.munfac.member.repository;

import com.kingmonkey.munfac.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Override
    Optional<Member> findById(Integer memberNo);
}
