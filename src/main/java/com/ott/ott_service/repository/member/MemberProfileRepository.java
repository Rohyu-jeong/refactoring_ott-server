package com.ott.ott_service.repository.member;

import com.ott.ott_service.model.member.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberProfileRepository extends JpaRepository<MemberProfile, Integer> {
    boolean existsByMemberEmail(String email);
}
