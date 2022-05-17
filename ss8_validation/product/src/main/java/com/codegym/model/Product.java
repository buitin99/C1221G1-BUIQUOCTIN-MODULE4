package com.codegym.model;

import javax.persistence.*;

//framework hibernate dua vao thuoc tinh trong class model de mapping xuong bang trong DB
@Entity
//annotation nay de dinh nghia ten cua object nay trong db
@Table(name = "product")
public class Product {
    //@ khai bao day la thuoc tinh primary key cua entity thuoc bo thu vien javax.persistence.*;
    @Id
    //@ khai bao primary key auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String describer;
    private String manufacture;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    public Product() {
    }

    public Product(String name, Double price, String describer, String manufacture, Category category) {
        this.name = name;
        this.price = price;
        this.describer = describer;
        this.manufacture = manufacture;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
