package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void create(Product product);

    Product findById(Integer id);

    void delete(Integer id);

    void update(Integer id, Product product);

    List<Product> search(String nameSearch);

//    Product search(String nameSearch);
}
