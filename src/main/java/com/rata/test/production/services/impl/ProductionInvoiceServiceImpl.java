package com.rata.test.production.services.impl;

import com.rata.test.production.entities.Barang;
import com.rata.test.production.entities.ProductionInvoice;
import com.rata.test.production.exception.ResourceNotFoundException;
import com.rata.test.production.repositories.BarangRepository;
import com.rata.test.production.repositories.ProductionInvoiceRepository;
import com.rata.test.production.services.ProductionInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service("productionInvoiceServiceImpl")
public class ProductionInvoiceServiceImpl implements ProductionInvoiceService {

    @Autowired
    private ProductionInvoiceRepository productionInvoiceRepository;

    @Autowired
    private BarangRepository barangRepository;

    @Override
    public List<ProductionInvoice> getAllProductionInvoice() {
        return productionInvoiceRepository.findAll();
    }

    @Override
    public ProductionInvoice getProductionInvoiceById(final String invoiceNumber) throws ResourceNotFoundException {
        return productionInvoiceRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("ProductionInvoice not found for this id :: " + invoiceNumber));
    }

    @Override
    public ProductionInvoice createProductionInvoice(final ProductionInvoice productionInvoice) {
        final String kodeBarang = productionInvoice.getBarang().getKodeBarang();
        Barang barang = barangRepository.findById(kodeBarang).orElse(null);
        if (ObjectUtils.isEmpty(barang)) {
            barang = new Barang();
            barang.setNamaBarang(productionInvoice.getBarang().getNamaBarang());
            barang.setHargaBarang(productionInvoice.getBarang().getHargaBarang());
        }

        productionInvoice.setBarang(barang);
        final int total = barang.getHargaBarang() * productionInvoice.getJumlah();
        productionInvoice.setTotal(total);
        return productionInvoiceRepository.save(productionInvoice);
    }

    @Override
    public ProductionInvoice updateProductionInvoice(final String invoiceNumber,final ProductionInvoice detailProductionInvoice)
            throws ResourceNotFoundException {
        ProductionInvoice productionInvoice = productionInvoiceRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("ProductionInvoice not found for this id :: " + invoiceNumber));

        final String kodeBarang = productionInvoice.getBarang().getKodeBarang();
        Barang barang = barangRepository.findById(kodeBarang).orElse(null);
        if (ObjectUtils.isEmpty(barang)) {
            barang = new Barang();
            barang.setNamaBarang(productionInvoice.getBarang().getNamaBarang());
            barang.setHargaBarang(productionInvoice.getBarang().getHargaBarang());
        }

        productionInvoice.setBarang(barang);
        productionInvoice.setJumlah(detailProductionInvoice.getJumlah());
        final int total = barang.getHargaBarang() * productionInvoice.getJumlah();
        productionInvoice.setTotal(total);
        productionInvoice.setTanggalPesan(detailProductionInvoice.getTanggalPesan());
        productionInvoice.setPenerima(detailProductionInvoice.getPenerima());
        productionInvoice.setAlamatPenerima(detailProductionInvoice.getAlamatPenerima());
        return productionInvoiceRepository.save(productionInvoice);
    }

    @Override
    public void deleteProductionInvoice(final String invoiceNumber) throws ResourceNotFoundException {
        ProductionInvoice productionInvoice = productionInvoiceRepository.findById(invoiceNumber)
                .orElseThrow(() -> new ResourceNotFoundException("ProductionInvoice not found for this id :: " + invoiceNumber));

        productionInvoiceRepository.delete(productionInvoice);
    }
}
