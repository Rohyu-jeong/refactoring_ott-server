package com.ott.ott_service.model.movie;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.ott.ott_service.model.wishlist.Wishlist;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    private int id;

    @Column(name = "title", unique = true, nullable = false, length = 100)
    private String title;

    @Column(name = "age_rating", length = 10)
    private String ageRating;

    @Column(name = "runtime")
    private int runtime;

    @Column(name = "rating")
    @ColumnDefault("0.0")
    @Builder.Default
    private double rating = 0.0;

    @Column(name = "teaser_url", length = 255)
    private String teaserUrl;

    @Column(name = "poster_img", length = 255)
    private String posterImg;

    @Column(name = "plot_summary", columnDefinition = "TEXT")
    private String plotSummary;

    @Column(name = "release_date")
    private String releaseDate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieGenre> genres;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieCategory> categories;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieDirector> directors;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieProduction> productions;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wishlist> wishlists;
}
