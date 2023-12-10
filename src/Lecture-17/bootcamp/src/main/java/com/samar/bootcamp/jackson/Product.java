package com.samar.bootcamp.jackson;

import lombok.ToString;

@ToString
public class Product {
    private int id;
    private String name;
    private String manufacturerName;

    private ProductMetaData productMetaData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public ProductMetaData getProductMetaData() {
        return productMetaData;
    }

    public void setProductMetaData(ProductMetaData productMetaData) {
        this.productMetaData = productMetaData;
    }
}
