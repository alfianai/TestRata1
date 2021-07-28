package com.rata.test.production.repositories;

import com.rata.test.production.entities.ProductionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionStatusRepository extends JpaRepository<ProductionStatus, String> {
}
