package com.quoctin.service.impl;

import com.quoctin.model.ProductType;
import com.quoctin.repository.IProductRepository;
import com.quoctin.repository.IProductTypeRepository;
import com.quoctin.service.IOrderProductService;
import com.quoctin.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {

    @Autowired
    private IProductTypeRepository iProductTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return iProductTypeRepository.findAll();
    }
}
