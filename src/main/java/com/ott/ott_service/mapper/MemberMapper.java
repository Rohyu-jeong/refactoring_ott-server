package com.ott.ott_service.mapper;

import com.ott.ott_service.dto.member.request.MemberCreateRequestDTO;
import com.ott.ott_service.model.member.Member;
import com.ott.ott_service.model.member.Membership;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member createMember(
            MemberCreateRequestDTO memberCreateRequestDTO,
            String password,
            Membership membership) {
        return Member.builder()
                .name(memberCreateRequestDTO.name())
                .email(memberCreateRequestDTO.email())
                .password(password)
                .membership(membership)
                .build();
    }

    public void updatePassword(Member member, String encodedPassword) {
        member.setPassword(encodedPassword);
    }
}
