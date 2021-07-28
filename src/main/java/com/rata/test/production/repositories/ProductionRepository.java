package com.rata.test.production.repositories;

import com.rata.test.production.entities.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, String> {
}
