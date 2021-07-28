package com.rata.test.production.services;

import com.rata.test.production.entities.Pembayaran;
import com.rata.test.production.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public interface PembayaranService {

    List<Pembayaran> getAllPembayaran();

    Pembayaran getPembayaranById(final String invoiceNumber) throws ResourceNotFoundException;

    byte[] renderImage(final String invoiceNumber) throws ResourceNotFoundException, IOException;

    Pembayaran createPembayaran(final Pembayaran pembayaran);

    void  uploadImage(final String invoiceNumber, final MultipartFile file) throws ResourceNotFoundException;

    Pembayaran updatePembayaran(final String invoiceNumber, final Pembayaran detailPembayaran)
            throws ResourceNotFoundException;

    void deletePembayaran(final String invoiceNumber) throws ResourceNotFoundException;
}
