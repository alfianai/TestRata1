package com.rata.test.production.repositories;

import com.rata.test.production.entities.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, String> {
}
