package com.rata.test.production.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "barang")
public class Barang {

    @Id
    @Column(name = "kode_barang")
    private String kodeBarang;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga_barang")
    private int hargaBarang;

    public Barang(){

    }
}
