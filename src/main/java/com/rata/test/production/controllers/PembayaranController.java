package com.rata.test.production.controllers;

import com.rata.test.production.entities.Pembayaran;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.repositories.PembayaranRepository;
import com.rata.test.production.services.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class PembayaranController {

    @Autowired
    private PembayaranService pembayaranService;

    @GetMapping("/pembayaran") //OK
    public ResponseEntity<List<Pembayaran>> getAllPembayaran() {
        final List<Pembayaran> listPembayaran = pembayaranService.getAllPembayaran();
        return new ResponseEntity<>(listPembayaran, HttpStatus.OK);
    }

    @GetMapping("/pembayaran/{invoice_number}") //OK
    public ResponseEntity<Pembayaran> getPembayaranById(@PathVariable(value = "invoice_number") String invoiceNumber)
            throws ResourceNotFoundException {
        final Pembayaran pembayaran = pembayaranService.getPembayaranById(invoiceNumber);
        return new ResponseEntity<>(pembayaran, HttpStatus.OK);
    }

    @PostMapping("/pembayaran") //OK
    public ResponseEntity<Pembayaran> createPembayaran(@Valid @RequestBody Pembayaran pembayaran) {
        final Pembayaran newPembayaran = pembayaranService.createPembayaran(pembayaran);
        return new ResponseEntity<>(newPembayaran, HttpStatus.OK);
    }

    @PutMapping("/pembayaran/{invoice_number}") //OK
    public ResponseEntity<Pembayaran> updatePembayaran(@PathVariable(value = "invoice_number") String invoiceNumber,
            @Valid @RequestBody Pembayaran detailPembayaran)  throws ResourceNotFoundException {
        final Pembayaran pembayaran = pembayaranService.updatePembayaran(invoiceNumber, detailPembayaran);
        return new ResponseEntity<>(pembayaran, HttpStatus.OK);
    }

    @DeleteMapping("/pembayaran/{invoice_number}") //OK
    public ResponseEntity<Map<String,String>> deletePembayaran(@PathVariable(value = "invoice_number") String invoiceNumber)
            throws ResourceNotFoundException {
        pembayaranService.deletePembayaran(invoiceNumber);
        Map<String,String> response = new HashMap<>();
        response.put("invoice number", invoiceNumber);
        response.put("deleted", "true");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
