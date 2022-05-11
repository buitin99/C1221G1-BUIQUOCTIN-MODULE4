package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getProductByName(String keyworkVal, Pageable pageable);

    void create(Product product);

    Product findById(Integer id);

    void deleteProduct(Product product);

    void update(Product product);
}
