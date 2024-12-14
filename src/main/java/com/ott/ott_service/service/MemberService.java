package com.ott.ott_service.service;

import com.ott.ott_service.dto.member.request.MemberChangePasswordRequestDTO;
import com.ott.ott_service.dto.member.request.MemberCreateRequestDTO;
import com.ott.ott_service.enums.MembershipLevel;
import com.ott.ott_service.exception.DuplicateDataException;
import com.ott.ott_service.exception.NotFoundException;
import com.ott.ott_service.mapper.MemberMapper;
import com.ott.ott_service.mapper.PaymentMapper;
import com.ott.ott_service.model.member.Member;
import com.ott.ott_service.model.member.Membership;
import com.ott.ott_service.model.member.Payment;
import com.ott.ott_service.repository.member.MemberRepository;
import com.ott.ott_service.repository.member.MembershipRepository;
import com.ott.ott_service.repository.member.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final MembershipRepository membershipRepository;
    private final PaymentRepository paymentRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;
    private final PaymentMapper paymentMapper;

    @Transactional
    public void createMember(MemberCreateRequestDTO memberCreateRequestDTO) {
        if (memberRepository.existsByEmail(memberCreateRequestDTO.email())) {
            throw new DuplicateDataException("이미 존재하는 회원");
        }

        MembershipLevel membershipLevel = MembershipLevel.fromAmount(memberCreateRequestDTO.amount());
        Membership membership = membershipRepository.findByLevel(membershipLevel.getDescription())
                .orElseThrow(() -> new NotFoundException("멤버십 레벨을 찾을 수 없습니다."));

        String encodedPassword = passwordEncoder.encode(memberCreateRequestDTO.password());
        Member member = memberMapper.createMember(memberCreateRequestDTO, encodedPassword, membership);
        memberRepository.save(member);

        Payment payment = paymentMapper.createToEntity(memberCreateRequestDTO);
        paymentRepository.save(payment);
    }

    @Transactional
    public void changePassword(int memberId, MemberChangePasswordRequestDTO requestDTO) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException("멤버를 찾을 수 없습니다."));

        String encodedPassword = passwordEncoder.encode(requestDTO.newPassword());
        memberMapper.updatePassword(member, encodedPassword);
        memberRepository.save(member);
    }

    @Transactional
    public void deleteMember (int memberId) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException("멤버를 찾을 수 없습니다."));
        memberRepository.deleteById(memberId);
    }
}