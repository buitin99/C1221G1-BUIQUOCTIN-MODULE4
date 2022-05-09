package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void create(Product product);

    Product findById(Integer id);

    void deleteProduct(Product product);

//    void update(Integer id,Product product);

    Product search(String nameSearch);

    void update(Product product);


//    Product search(String nameSearch);
}
