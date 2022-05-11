package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> getProductByName(String keyworkVal, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(keyworkVal,pageable);
    }

    @Override
    public void create(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }
}
