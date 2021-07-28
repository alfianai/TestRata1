package com.rata.test.production.services;

import com.rata.test.production.entities.ProductionStatus;
import com.rata.test.production.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductionStatusService {

    List<ProductionStatus> getAllProductionStatus();

    ProductionStatus getProductionStatusById(final String invoiceNumber) throws ResourceNotFoundException;

    ProductionStatus createProductionStatus(final ProductionStatus productionStatus);

    ProductionStatus updateProductionStatus(final String invoiceNumber, final ProductionStatus detailProductionStatus)
            throws ResourceNotFoundException;

    void deleteProductionStatus(final String invoiceNumber) throws ResourceNotFoundException;
}
