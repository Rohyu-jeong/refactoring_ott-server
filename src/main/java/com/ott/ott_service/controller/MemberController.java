package com.ott.ott_service.controller;

import com.ott.ott_service.dto.member.request.MemberChangePasswordRequestDTO;
import com.ott.ott_service.dto.member.request.MemberCreateRequestDTO;
import com.ott.ott_service.service.MemberService;
import com.ott.ott_service.validation.ValidIntId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
@Validated
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> createMember(
            @Valid @RequestBody MemberCreateRequestDTO requestDTO
    ) {
        memberService.createMember(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입이 성공적으로 완료되었습니다.");
    }

    @PutMapping("/{memberId}/changePassword")
    public ResponseEntity<Void> changePassword(
            @PathVariable @ValidIntId int memberId,
            @Valid @RequestBody MemberChangePasswordRequestDTO requestDTO
    ) {
        memberService.changePassword(memberId, requestDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember (
            @PathVariable @ValidIntId int memberId
    ) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
