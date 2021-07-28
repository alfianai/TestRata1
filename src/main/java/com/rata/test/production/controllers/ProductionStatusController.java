package com.rata.test.production.controllers;

import com.rata.test.production.entities.ProductionStatus;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.services.ProductionStatusService;
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
public class ProductionStatusController {

    @Autowired
    private ProductionStatusService productionStatusService;

    @GetMapping("/productionStatus") //OK
    public ResponseEntity<List<ProductionStatus>> getAllProductionStatus() {
        final List<ProductionStatus> productionStatuses = productionStatusService.getAllProductionStatus();
        return new ResponseEntity<>(productionStatuses, HttpStatus.OK);
    }

    @GetMapping("/productionStatus/{invoice_number}") //OK
    public ResponseEntity<ProductionStatus> getProductionStatusById(@PathVariable(value = "invoice_number") String invoiceNumber)
            throws ResourceNotFoundException {
        final ProductionStatus productionStatus = productionStatusService.getProductionStatusById(invoiceNumber);
        return new ResponseEntity<>(productionStatus, HttpStatus.OK);
    }

    @PostMapping("/productionStatus") //OK
    public ResponseEntity<ProductionStatus> createProductionStatus(@Valid @RequestBody ProductionStatus productionStatus) {
        final ProductionStatus prodStatus = productionStatusService.createProductionStatus(productionStatus);
        return new ResponseEntity<>(prodStatus, HttpStatus.OK);
    }

    @PutMapping("/productionStatus/{invoice_number}") //OK
    public ResponseEntity<ProductionStatus> updateProductionStatus(@PathVariable(value = "invoice_number") String invoiceNumber,
            @Valid @RequestBody ProductionStatus detailProductionStatus) throws ResourceNotFoundException {
        final ProductionStatus ProductionStatus = productionStatusService.updateProductionStatus(invoiceNumber, detailProductionStatus);
        return new ResponseEntity<>(ProductionStatus, HttpStatus.OK);
    }

    @DeleteMapping("/productionStatus/{invoice_number}") //OK
    public ResponseEntity<Map<String,String>> deleteProductionStatus(@PathVariable(value = "invoice_number") String invoiceNumber)
            throws ResourceNotFoundException {
        productionStatusService.deleteProductionStatus(invoiceNumber);
        Map<String,String> response = new HashMap<>();
        response.put("invoice number", invoiceNumber);
        response.put("deleted", "true");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
