package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void create(Product product);

    Product findById(Integer id);

    void delete(Product product);

//    void update(Integer id, Product product);

    Product search(String nameSearch);

    void update(Product product);
}
