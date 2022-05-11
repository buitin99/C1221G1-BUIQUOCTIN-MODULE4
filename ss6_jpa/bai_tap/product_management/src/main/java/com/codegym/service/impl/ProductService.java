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

//    @Override
//    public List<Product> findAll() {
//        return this.iProductRepository.findAll();
//    }
//
//    @Override
//    public void create(Product product) {
//        this.iProductRepository.create(product);
//    }
//
//    @Override
//    public Product findById(Integer id) {
//        return this.iProductRepository.findById(id);
//    }
//
//    @Override
//    public void deleteProduct(Product product) {
//        this.iProductRepository.delete(product);
//    }
//
//    @Override
//    public void update(Product product) {
//        this.iProductRepository.update(product);
//    }

    @Override
    public Page<Product> getListByName(String keyworkVal, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(keyworkVal, pageable);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

}
