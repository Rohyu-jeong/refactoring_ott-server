package com.ott.ott_service.enums;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum MembershipLevel {
    PREMIUM(BigDecimal.valueOf(17000), "프리미엄(Premium) 4K+HDR"),
    STANDARD(BigDecimal.valueOf(13500), "스탠다드(Standard) 1080p"),
    AD_STANDARD(BigDecimal.valueOf(5500), "광고형스탠다드(AD) 1080p");

    private final BigDecimal amount;
    private final String description;

    MembershipLevel(BigDecimal amount, String description) {
        this.amount = amount;
        this.description = description;
    }


    public static MembershipLevel fromAmount(BigDecimal amount) {
        for (MembershipLevel level : values()) {
            if (level.getAmount().equals(amount)) {
                return level;
            }
        }
        throw new IllegalArgumentException("멤버십 등급에 맞지 않는 결제 금액입니다.");
    }
}