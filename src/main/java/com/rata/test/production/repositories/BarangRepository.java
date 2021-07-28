package com.rata.test.production.repositories;

import com.rata.test.production.entities.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang, String> {
}
