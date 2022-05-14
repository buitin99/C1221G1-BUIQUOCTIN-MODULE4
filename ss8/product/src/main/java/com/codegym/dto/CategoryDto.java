package com.codegym.dto;


import com.codegym.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class CategoryDto implements Validator {

    private Integer id;
    private String typeProduct;
    private List<Product> productList;

    public CategoryDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
