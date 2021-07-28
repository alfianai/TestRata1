package com.rata.test.production.services;

import com.rata.test.production.entities.Pembayaran;
import com.rata.test.production.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PembayaranService {

    List<Pembayaran> getAllPembayaran();

    Pembayaran getPembayaranById(final String invoiceNumber) throws ResourceNotFoundException;

    Pembayaran createPembayaran(final Pembayaran pembayaran);

    Pembayaran updatePembayaran(final String invoiceNumber, final Pembayaran detailPembayaran) throws ResourceNotFoundException;

    void deletePembayaran(final String invoiceNumber) throws ResourceNotFoundException;
}
