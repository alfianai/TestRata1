package com.rata.test.production.services;

import com.rata.test.production.entities.ProductionInvoice;
import com.rata.test.production.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductionInvoiceService {

    List<ProductionInvoice> getAllProductionInvoice();

    ProductionInvoice getProductionInvoiceById(final String invoiceNumber) throws ResourceNotFoundException;

    ProductionInvoice createProductionInvoice(final ProductionInvoice productionInvoice);

    ProductionInvoice updateProductionInvoice(final String invoiceNumber,final ProductionInvoice detailProductionInvoice)
            throws ResourceNotFoundException;

    void deleteProductionInvoice(final String invoiceNumber) throws ResourceNotFoundException;
}
