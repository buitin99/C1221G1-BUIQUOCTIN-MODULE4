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
        return this.iProductRepository.findAll();
    }

    @Override
    public void create(Product product) {
        this.iProductRepository.create(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.iProductRepository.findById(id);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.iProductRepository.delete(id);
    }

//    @Override
//    public Product search(String nameSearch) {
//        return this.iProductRepository.search(nameSearch);
//    }
}
