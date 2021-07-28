package com.rata.test.production.services.impl;

import com.rata.test.production.entities.ProductionStatus;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.repositories.ProductionRepository;
import com.rata.test.production.repositories.ProductionStatusRepository;
import com.rata.test.production.services.ProductionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productionStatusServiceImpl")
public class ProductionStatusServiceImpl implements ProductionStatusService {

    @Autowired
    private ProductionStatusRepository productionStatusRepository;

    @Autowired
    private ProductionRepository productionRepository;

    @Override
    public List<ProductionStatus> getAllProductionStatus() {
        return productionStatusRepository.findAll();
    }

    @Override
    public ProductionStatus getProductionStatusById(final String invoiceNumber) throws ResourceNotFoundException {
        return productionStatusRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("ProductionStatus not found for this id :: " + invoiceNumber));
    }

    @Override
    public ProductionStatus createProductionStatus(final ProductionStatus productionStatus) {
        return productionStatusRepository.save(productionStatus);
    }

    @Override
    public ProductionStatus updateProductionStatus(final String invoiceNumber, final ProductionStatus detailProductionStatus)
            throws ResourceNotFoundException {
        ProductionStatus productionStatus = productionStatusRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("ProductionStatus not found for this id :: " + invoiceNumber));

        productionStatus.setStatus(detailProductionStatus.getStatus());
        productionStatus.setCatatan(detailProductionStatus.getCatatan());
        productionStatus.setTanggalMasuk(detailProductionStatus.getTanggalMasuk());
        productionStatus.setTanggalProduksi(detailProductionStatus.getTanggalProduksi());
        productionStatus.setTanggalSelesai(detailProductionStatus.getTanggalSelesai());
        return productionStatusRepository.save(productionStatus);
    }

    @Override
    public void deleteProductionStatus(final String invoiceNumber) throws ResourceNotFoundException {
        ProductionStatus productionStatus = productionStatusRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("ProductionStatus not found for this id :: " + invoiceNumber));

        productionStatusRepository.delete(productionStatus);

    }
}
