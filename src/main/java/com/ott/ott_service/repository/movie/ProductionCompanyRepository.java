package com.ott.ott_service.repository.movie;

import com.ott.ott_service.model.movie.ProductionCompany;
import com.ott.ott_service.util.CompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCompanyRepository extends JpaRepository<ProductionCompany, CompositeKey> {
}
