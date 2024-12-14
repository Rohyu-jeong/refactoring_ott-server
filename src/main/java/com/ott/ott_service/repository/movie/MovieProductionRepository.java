package com.ott.ott_service.repository.movie;

import com.ott.ott_service.model.movie.MovieDirector;
import com.ott.ott_service.util.CompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieProductionRepository extends JpaRepository<MovieDirector, CompositeKey> {
}
