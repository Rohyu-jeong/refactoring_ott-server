package com.ott.ott_service.model.member;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "membership")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING) //todo 없애도될지도
    @Column(name = "level", unique = true, nullable = false, length = 50)
    private String level;

    @Column(name ="amount", nullable = false)
    private double amount;
}
