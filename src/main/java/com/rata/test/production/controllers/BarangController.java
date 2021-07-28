package com.rata.test.production.controllers;

import com.rata.test.production.entities.Barang;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.services.impl.BarangServiceImpl;
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
public class BarangController {

    @Autowired
    private BarangServiceImpl barangService;

    @GetMapping("/barang") //OK
    public ResponseEntity<List<Barang>> getAllBarang() {
        final List<Barang> listBarang = barangService.getAllBarang();
        return new ResponseEntity<>(listBarang, HttpStatus.OK);
    }

    @GetMapping("/barang/{kode_barang}") //OK
    public ResponseEntity<Barang> getBarangById(@PathVariable(value = "kode_barang") String kodeBarang)
            throws ResourceNotFoundException {
        final Barang barang = barangService.getBarangById(kodeBarang);
        return new ResponseEntity<>(barang, HttpStatus.OK);
    }

    @PostMapping("/barang") //OK
    public ResponseEntity<Barang> createBarang(@Valid @RequestBody Barang barang) {
        final Barang brg =barangService.createBarang(barang);
        return new ResponseEntity<>(brg, HttpStatus.OK);
    }

    @PutMapping("/barang/{kode_barang}") //OK
    public ResponseEntity<Barang> updateBarang(@PathVariable(value = "kode_barang") String kodeBarang,
            @Valid @RequestBody Barang detailBarang)  throws ResourceNotFoundException {
        final Barang brg = barangService.updateBarang(kodeBarang, detailBarang);
        return new ResponseEntity<>(brg, HttpStatus.OK);
    }

    @DeleteMapping("/barang/{kode_barang}") //OK
    public ResponseEntity<Map<String,String>> deleteBarang(@PathVariable(value = "kode_barang") String kodeBarang)
            throws  ResourceNotFoundException {
        barangService.deleteBarang(kodeBarang);
        Map<String,String> response = new HashMap<>();
        response.put("kode barang", kodeBarang);
        response.put("deleted", "true");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}