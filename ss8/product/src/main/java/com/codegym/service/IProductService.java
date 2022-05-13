package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Page<Product> findByNameContaining(String nameSearch, Pageable pageable);
}
