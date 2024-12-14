package com.ott.ott_service.repository.member;

import com.ott.ott_service.model.member.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {
    Optional<Membership> findByLevel(String level);
}
