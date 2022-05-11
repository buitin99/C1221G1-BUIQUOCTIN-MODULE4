package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public List<Product> findAll() {
        return findAll();
    }

    @Override
    public void create(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Product product) {
        this.iProductRepository.delete(product);
    }

    @Override
    public void update(Product product) {
        this.iProductRepository.save(product);
    }

}
