package com.quoctin.dto;

import com.quoctin.model.Product;

import javax.persistence.OneToMany;
import java.util.List;

public class ProductTypeDto {

    private Integer id;
    private String name;
    private List<Product> productList;

    public ProductTypeDto() {
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
