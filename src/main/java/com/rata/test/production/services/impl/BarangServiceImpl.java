package com.rata.test.production.services.impl;

import com.rata.test.production.entities.Barang;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.repositories.BarangRepository;
import com.rata.test.production.services.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("barangServiceImpl")
public class BarangServiceImpl implements BarangService {

    @Autowired
    private BarangRepository barangRepository;

    @Override
    public List<Barang> getAllBarang() {
        return barangRepository.findAll();
    }

    @Override
    public Barang getBarangById(final String kodeBarang) throws ResourceNotFoundException {
        return barangRepository.findById(kodeBarang)
                .orElseThrow(() -> new ResourceNotFoundException("Barang not found for this id :: " + kodeBarang));
    }

    @Override
    public Barang createBarang(final Barang barang) {
        return barangRepository.save(barang);
    }

    @Override
    public Barang updateBarang(final String kodeBarang, final Barang detailBarang) throws ResourceNotFoundException {
        Barang barang = barangRepository.findById(kodeBarang)
                .orElseThrow(() -> new ResourceNotFoundException("Barang not found for this id :: " + kodeBarang));

        barang.setNamaBarang(detailBarang.getNamaBarang());
        barang.setHargaBarang(detailBarang.getHargaBarang());
        return barangRepository.save(barang);
    }

    @Override
    public void deleteBarang(final String kodeBarang) throws ResourceNotFoundException {
        Barang barang = barangRepository.findById(kodeBarang)
                .orElseThrow(() -> new ResourceNotFoundException("Barang not found for this id :: " + kodeBarang));

        barangRepository.delete(barang);
    }
}
