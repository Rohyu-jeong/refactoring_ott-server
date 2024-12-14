package com.ott.ott_service.repository.movie;

import com.ott.ott_service.model.movie.MovieGenre;
import com.ott.ott_service.util.CompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, CompositeKey> {
}
