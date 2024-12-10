package com.ott.ott_service.model.member;

import com.ott.ott_service.model.wishlist.Wishlist;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "memberprofile")
public class MemberProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;

    @Column(name = "member_name", nullable = false, length = 50)
    private String memberName;

    @Column(name = "member_email", unique = true, nullable = false, length = 320)
    private String memberEmail;

    @Column(name = "member_password", nullable = false, length = 60)
    private String memberPassword;

    @OneToMany(mappedBy = "memberProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wishlist> wishlists;
}
