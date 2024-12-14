package com.ott.ott_service.dto.member.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record MemberChangePasswordRequestDTO(
        @NotBlank(message = "NewPassword is required.")
        @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$",
                message = "Password must contain at least one letter, one number, and one special character."
        )
        String newPassword
) {
}
