package com.ott.ott_service.model.wishlist;

import com.ott.ott_service.model.member.Member;
import com.ott.ott_service.model.member.MemberProfile;
import com.ott.ott_service.model.movie.Movie;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "memberprofile_id", referencedColumnName = "id")
    private MemberProfile memberProfile;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;
}
