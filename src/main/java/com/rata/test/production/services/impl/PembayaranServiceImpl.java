package com.rata.test.production.services.impl;

import com.rata.test.production.entities.Pembayaran;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.repositories.PembayaranRepository;
import com.rata.test.production.services.PembayaranService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("pembayaranServiceImpl")
public class PembayaranServiceImpl implements PembayaranService {

    Logger log = LoggerFactory.getLogger(PembayaranServiceImpl.class);

    @Autowired
    private PembayaranRepository pembayaranRepository;

    @Override
    public List<Pembayaran> getAllPembayaran() {
        return pembayaranRepository.findAll();
    }

    @Override
    public Pembayaran getPembayaranById(final String invoiceNumber) throws ResourceNotFoundException {
        return pembayaranRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Pembayaran not found for this id :: " + invoiceNumber));
    }

    @Override
    public byte[] renderImage(final String invoiceNumber) throws ResourceNotFoundException, IOException {
        Pembayaran pembayaran = pembayaranRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Pembayaran not found for this id :: " + invoiceNumber));
        return getImage(pembayaran.getBuktiBayar());
    }

    @Override
    public Pembayaran createPembayaran(final Pembayaran pembayaran) {
        return pembayaranRepository.save(pembayaran);
    }

    @Override
    public void uploadImage(final String invoiceNumber, final MultipartFile file)
            throws ResourceNotFoundException {
        Pembayaran pembayaran = pembayaranRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Pembayaran not found for this id :: " + invoiceNumber));
        pembayaran.setBuktiBayar(saveImage(file));
        pembayaranRepository.save(pembayaran);
    }

    @Override
    public Pembayaran updatePembayaran(final String invoiceNumber, final Pembayaran detailPembayaran)throws ResourceNotFoundException {
        Pembayaran pembayaran = pembayaranRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Pembayaran not found for this id :: " + invoiceNumber));

        pembayaran.setMetodeBayar(detailPembayaran.getMetodeBayar());
        pembayaran.setStatus(detailPembayaran.getStatus());
        pembayaran.setTanggalBayar(detailPembayaran.getTanggalBayar());
        return pembayaranRepository.save(pembayaran);
    }

    @Override
    public void deletePembayaran(final String invoiceNumber) throws ResourceNotFoundException {
        Pembayaran pembayaran = pembayaranRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Pembayaran not found for this id :: " + invoiceNumber));

        pembayaranRepository.delete(pembayaran);
    }

    private byte[] saveImage(MultipartFile file) {
        try {
            byte[] byteObjects = new byte[file.getBytes().length];
            int i = 0;
            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }
            return byteObjects;

        } catch (IOException e) {
            log.error("Error occurred", e);
            e.printStackTrace();
            return null;
        }
    }

    private byte[] getImage(final byte[] image) throws IOException {
        if (image != null) {
            byte[] byteArray = new byte[image.length];
            int i = 0;

            for (byte wrappedByte : image){
                byteArray[i++] = wrappedByte; //auto unboxing
            }
            return byteArray;
        }
        return null;
    }
}
