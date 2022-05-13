package com.codegym.service.impl;

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
    public Page<Product> getListByName(String keyworkVal, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(keyworkVal, pageable);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }


}
