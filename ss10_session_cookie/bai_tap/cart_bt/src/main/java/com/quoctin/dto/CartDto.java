package com.quoctin.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {

    private Map<ProductDto,Integer> products = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }
}
