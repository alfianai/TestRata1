package com.rata.test.production.services.impl;

import com.rata.test.production.entities.Barang;
import com.rata.test.production.entities.Production;
import com.rata.test.production.entities.ProductionStatus;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.repositories.ProductionRepository;
import com.rata.test.production.repositories.ProductionStatusRepository;
import com.rata.test.production.services.ProductionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
