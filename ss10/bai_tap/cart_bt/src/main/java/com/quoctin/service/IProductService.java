package com.quoctin.service;

import com.quoctin.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
    Iterable<Product> findAll();
}
