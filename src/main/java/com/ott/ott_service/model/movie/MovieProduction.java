package com.ott.ott_service.model.movie;

import com.ott.ott_service.util.CompositeKey;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "movieproduction")
public class MovieProduction {
    @EmbeddedId
    private CompositeKey id;

    @MapsId("movieId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @MapsId("entityId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "production_company_id", referencedColumnName = "id", nullable = false)
    private ProductionCompany productionCompany;
}
