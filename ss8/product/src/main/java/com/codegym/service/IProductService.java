package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    void save(Product product);

    Page<Product> findByNameContaining(String nameSearch, Pageable pageable);


    Page<Product> findProductCustom(String nameSearch, String desSearch, String typeSearch, Pageable pageable);
}
