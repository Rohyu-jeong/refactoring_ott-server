package com.ott.ott_service.service;

import com.ott.ott_service.repository.member.MemberRepository;
import com.ott.ott_service.repository.member.MemberProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmailValidationService {
    private final MemberRepository memberRepository;
    private final MemberProfileRepository memberProfileRepository;

    @Transactional (readOnly = true)
    public boolean isEmailDuplicate(String email) {
        return memberRepository.existsByEmail(email) || memberProfileRepository.existsByMemberEmail(email);
    }
}
