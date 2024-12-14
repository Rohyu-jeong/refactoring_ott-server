package com.ott.ott_service.mapper;

import com.ott.ott_service.dto.member.request.MemberCreateRequestDTO;
import com.ott.ott_service.model.member.Payment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PaymentMapper {
    public Payment createToEntity(MemberCreateRequestDTO memberCreateRequestDTO) {
        return Payment.builder()
                .cardNumber(memberCreateRequestDTO.cardNumber())
                .expiryDate(memberCreateRequestDTO.expiryDate())
                .cardName(memberCreateRequestDTO.cardName())
                .amount(memberCreateRequestDTO.amount())
                .build();
    }
}
