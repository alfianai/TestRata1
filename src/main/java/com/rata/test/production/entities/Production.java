package com.rata.test.production.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Production {

    @Id
    @Column(name = "invoice_number")
    private String invoiceNumber;

    public Production() {

    }
}
