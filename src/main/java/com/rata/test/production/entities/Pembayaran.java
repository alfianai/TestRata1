package com.rata.test.production.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pembayaran")
@PrimaryKeyJoinColumn(name = "invoice_number")
public class Pembayaran extends Production {

    @Column(name = "metode_bayar")
    private String metodeBayar;

    @Lob
    @Column(name = "bukti_bayar")
    private byte[] buktiBayar;

    @Column(name = "status")
    private String status;

    @Column(name = "tanggal_bayar")
    private LocalDate tanggalBayar;

    public Pembayaran() {

    }
}
