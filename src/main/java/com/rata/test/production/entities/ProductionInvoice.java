package com.rata.test.production.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "production_invoice")
@PrimaryKeyJoinColumn(name = "invoice_number")
public class ProductionInvoice extends Production {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "kode_barang"), name = "kode_barang")
    private Barang barang;

    @Column(name = "jumlah")
    private int jumlah;

    @Column(name = "total")
    private int total;

    @Column(name = "tanggal_pesan")
    private LocalDate tanggalPesan;

    @Column(name = "penerima")
    private String penerima;

    @Column(name = "alamat_penerima")
    private String alamatPenerima;

    public ProductionInvoice() {

    }
}
