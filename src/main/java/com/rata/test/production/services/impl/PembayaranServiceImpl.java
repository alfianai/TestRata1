package com.rata.test.production.services.impl;

import com.rata.test.production.entities.Pembayaran;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.repositories.PembayaranRepository;
import com.rata.test.production.services.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("pembayaranServiceImpl")
public class PembayaranServiceImpl implements PembayaranService {

    @Autowired
    private PembayaranRepository pembayaranRepository;

    public List<Pembayaran> getAllPembayaran() {
        return pembayaranRepository.findAll();
    }

    public Pembayaran getPembayaranById(final String invoiceNumber) throws ResourceNotFoundException {
        return pembayaranRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Pembayaran not found for this id :: " + invoiceNumber));
    }

    public Pembayaran createPembayaran(final Pembayaran pembayaran) {
        return pembayaranRepository.save(pembayaran);
    }

    public Pembayaran updatePembayaran(final String invoiceNumber, final Pembayaran detailPembayaran) throws ResourceNotFoundException {
        Pembayaran pembayaran = pembayaranRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Pembayaran not found for this id :: " + invoiceNumber));

        pembayaran.setMetodeBayar(detailPembayaran.getMetodeBayar());
        pembayaran.setBuktiBayar(detailPembayaran.getBuktiBayar());
        pembayaran.setStatus(detailPembayaran.getStatus());
        pembayaran.setTanggalBayar(detailPembayaran.getTanggalBayar());
        return pembayaranRepository.save(pembayaran);
    }

    public void deletePembayaran(final String invoiceNumber) throws ResourceNotFoundException {
        Pembayaran pembayaran = pembayaranRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Pembayaran not found for this id :: " + invoiceNumber));

        pembayaranRepository.delete(pembayaran);
    }
}
