package com.ott.ott_service.repository.member;

import com.ott.ott_service.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    boolean existsByEmail(String email);
}
