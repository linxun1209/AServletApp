package com.example;

import java.math.BigDecimal;

public class Commodity {
    private Long id;
    private String name;
    private BigDecimal price;
    private String describe;

    public Commodity() {
    }

    public Commodity(Long id, String name, BigDecimal price, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
    }

    public Commodity(String name, BigDecimal price, String describe) {
        this.name = name;
        this.price = price;
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
