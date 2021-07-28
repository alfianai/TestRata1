package com.rata.test.production.repositories;

import com.rata.test.production.entities.ProductionInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionInvoiceRepository extends JpaRepository<ProductionInvoice, String> {
}
