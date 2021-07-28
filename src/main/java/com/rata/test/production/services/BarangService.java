package com.rata.test.production.services;

import com.rata.test.production.entities.Barang;
import com.rata.test.production.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BarangService {

    List<Barang> getAllBarang();

    Barang getBarangById(final String kodeBarang) throws ResourceNotFoundException;

    Barang createBarang(final Barang barang);

    Barang updateBarang(final String kodeBarang, final Barang detailBarang) throws ResourceNotFoundException;

    void deleteBarang(final String kodeBarang) throws ResourceNotFoundException;
}
