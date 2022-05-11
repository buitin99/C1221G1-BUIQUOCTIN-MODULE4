package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
//    List<Product> findAll();
//
//    void create(Product product);
//
//    Product findById(Integer id);
//
//    void deleteProduct(Product product);
//
//    void update(Product product);

    Page<Product> getListByName(String keyworkVal, Pageable pageable);

    Page<Product> findAll(Pageable pageable);
}
