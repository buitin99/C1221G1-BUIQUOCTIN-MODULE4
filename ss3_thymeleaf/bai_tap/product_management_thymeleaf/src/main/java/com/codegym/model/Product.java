package com.codegym.model;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String describer;
    private String manufacture;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String describer, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describer = describer;
        this.manufacture = manufacture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
