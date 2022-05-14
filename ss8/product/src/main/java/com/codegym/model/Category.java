package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typeProduct;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public Category() {
    }

    public Category(String typeProduct, List<Product> productList) {
        this.typeProduct = typeProduct;
        this.productList = productList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
