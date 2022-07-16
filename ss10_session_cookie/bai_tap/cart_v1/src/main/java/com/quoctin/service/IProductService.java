package com.quoctin.service;

import com.quoctin.model.Product;
import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Integer id);
}
