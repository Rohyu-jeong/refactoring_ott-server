package com.ott.ott_service.dto.member.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record MemberCreateRequestDTO(
        @NotBlank(message = "이름은 필수입니다.")
        @Size(min = 3, max = 50, message = "이름은 50글자 이하여야 합니다.")
        String name,

        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "유효한 이메일 주소를 입력하세요.")
        String email,

        @NotBlank(message = "비밀번호는 필수입니다.")
        @Size(min = 8, max = 16, message = "비밀번호는 8자 이상 16자 이하여야 합니다.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&]).{8,16}$",
                message = "비밀번호는 최소 하나의 문자, 숫자, 특수 문자를 포함해야 합니다."
        )
        String password,

        @NotBlank(message = "카드 번호는 필수입니다.")
        @Pattern(regexp = "\\d{16}", message = "카드 번호는 16자리 숫자여야 합니다.")
        String cardNumber,

        @NotBlank(message = "만료일은 필수입니다.")
        @Pattern(regexp = "^(0[1-9]|1[0-2])/\\d{2}$", message = "만료일은 MM/YY 형식이어야 합니다.")
        String expiryDate,

        @NotBlank(message = "카드 이름은 필수입니다.")
        @Size(max = 20, message = "카드 이름은 20자 이하여야 합니다.")
        String cardName,

        @NotNull(message = "금액은 필수입니다.")
        @DecimalMin(value = "0.0", inclusive = false, message = "금액은 0보다 커야 합니다.")
        BigDecimal amount
) {
}
