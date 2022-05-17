package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Page<Product> findByNameContaining(String nameSearch, Pageable pageable) {
        return iProductRepository.findByNameContaining(nameSearch,pageable);
    }

    @Override
    public Page<Product> findProductCustom(String nameSearch, String desSearch, String typeSearch, Pageable pageable) {
        return iProductRepository.findProductCustom(nameSearch  , desSearch  , typeSearch  ,pageable);
    }



}
