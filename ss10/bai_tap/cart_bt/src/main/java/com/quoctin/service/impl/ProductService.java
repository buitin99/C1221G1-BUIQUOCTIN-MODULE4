package com.quoctin.service.impl;

import com.quoctin.model.Product;
import com.quoctin.repository.IProductRepository;
import com.quoctin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }
}
