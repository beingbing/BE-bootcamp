package com.samar.bootcamp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "2020offer")
public class LockdownOffer {

    // *IDENTITY: whatever value DB gives, keep it
    // AUTO: application will generate a unique id
    // *UUID: generate a string unique id
    // SEQUENCE: custom id generator in sequence
    // TABLE: will provide a table name which will contain value of id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "avg_amt")
    private Long avgAmt;

    @Column(name = "avg_cnt")
    private Long avgCnt;
}
