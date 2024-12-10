package com.ott.ott_service.model.member;

import com.ott.ott_service.model.wishlist.Wishlist;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", unique = true, nullable = false, length = 320)
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @OneToOne(optional = false)
    @JoinColumn(name = "membership_id", referencedColumnName = "id", nullable = false)
    private Membership membership;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval =  true)
    private List<MemberProfile> memberProfiles;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wishlist> wishlists;
}
