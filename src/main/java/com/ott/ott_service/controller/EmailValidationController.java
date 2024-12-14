package com.ott.ott_service.controller;

import com.ott.ott_service.service.EmailValidationService;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/validation")
@RequiredArgsConstructor
public class EmailValidationController {
    private final EmailValidationService emailValidationService;

    @GetMapping("/email")
    public ResponseEntity<Boolean> checkEmailDuplicate(
            @RequestBody @Email String email
            ) {
        boolean isDuplicate = emailValidationService.isEmailDuplicate(email);
        return ResponseEntity.ok(isDuplicate);
    }
}
