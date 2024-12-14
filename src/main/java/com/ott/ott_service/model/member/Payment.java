package com.ott.ott_service.model.member;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(optional = false)
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;

    @Column(name = "card_number", nullable = false, length = 20)
    private String cardNumber;

    @Column(name = "expiry_date", nullable = false, length = 10)
    private String expiryDate;

    @Column(name = "payment_date", nullable = false)
    @Builder.Default
    private LocalDateTime paymentDate = LocalDateTime.now();

    @Column(name = "card_name", nullable = false, length = 20)
    private String cardName;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
}
