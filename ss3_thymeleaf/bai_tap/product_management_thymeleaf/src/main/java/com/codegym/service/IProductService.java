package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void create(Product product);

    Product findById(Integer id);

    void deleteProduct(Integer id);

    void update(Integer id,Product product);

    List<Product> search(String nameSearch);


//    Product search(String nameSearch);
}
