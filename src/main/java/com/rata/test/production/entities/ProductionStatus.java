package com.rata.test.production.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "production_status")
@PrimaryKeyJoinColumn(name = "invoice_number")
public class ProductionStatus extends Production {

    @Column(name = "status")
    private String status;

    @Column(name = "catatan")
    private String catatan;

    @Column(name = "tanggal_masuk")
    private LocalDate tanggalMasuk;

    @Column(name = "tanggal_produksi")
    private LocalDate tanggalProduksi;

    @Column(name = "tanggal_Selesai")
    private LocalDate tanggalSelesai;

    public ProductionStatus() {

    }
}
