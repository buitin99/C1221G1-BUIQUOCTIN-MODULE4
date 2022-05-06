package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void create(Product product);

    Product findById(Integer id);

    void deleteProduct(Integer id);

//    Product search(String nameSearch);
}
