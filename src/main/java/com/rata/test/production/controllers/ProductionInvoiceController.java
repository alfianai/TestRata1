package com.rata.test.production.controllers;

import com.rata.test.production.entities.ProductionInvoice;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.services.impl.ProductionInvoiceServiceImpl;
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
public class ProductionInvoiceController {

    @Autowired
    private ProductionInvoiceServiceImpl productionInvoiceService;

    @GetMapping("/productionInvoice") //OK
    public ResponseEntity<List<ProductionInvoice>> getAllProductionInvoice() {
        final List<ProductionInvoice> productionInvoices = productionInvoiceService.getAllProductionInvoice();
        return new ResponseEntity<>(productionInvoices, HttpStatus.OK);
    }

    @GetMapping("/productionInvoice/{invoice_number}") //OK
    public ResponseEntity<ProductionInvoice> getProductionInvoiceById(@PathVariable(value = "invoice_number") String invoiceNumber)
            throws ResourceNotFoundException {
        final ProductionInvoice productionInvoice = productionInvoiceService.getProductionInvoiceById(invoiceNumber);
        return new ResponseEntity<>(productionInvoice, HttpStatus.OK);
    }

    @PostMapping("/productionInvoice") //OK
    public ResponseEntity<ProductionInvoice> createProductionInvoice(@Valid @RequestBody ProductionInvoice productionInvoice) {
        final ProductionInvoice prodInvoice = productionInvoiceService.createProductionInvoice(productionInvoice);
        return new ResponseEntity<>(prodInvoice, HttpStatus.OK);
    }

    @PutMapping("/productionInvoice/{invoice_number}") //OK
    public ResponseEntity<ProductionInvoice> updateProductionInvoice(@PathVariable(value = "invoice_number") String invoiceNumber,
            @Valid @RequestBody ProductionInvoice detailProductionInvoice)  throws ResourceNotFoundException {
        final ProductionInvoice productionInvoice = productionInvoiceService.updateProductionInvoice(invoiceNumber, detailProductionInvoice);
        return new ResponseEntity<>(productionInvoice, HttpStatus.OK);
    }

    @DeleteMapping("/productionInvoice/{invoice_number}") //OK
    public ResponseEntity<Map<String,String>> deleteProductionInvoice(@PathVariable(value = "invoice_number") String invoiceNumber)
            throws  ResourceNotFoundException {
        productionInvoiceService.deleteProductionInvoice(invoiceNumber);
        Map<String,String> response = new HashMap<>();
        response.put("invoice number", invoiceNumber);
        response.put("deleted", "true");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
