package com.quoctin.service.impl;

import com.quoctin.model.OrderProduct;
import com.quoctin.repository.IOrderProductRepository;
import com.quoctin.service.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService implements IOrderProductService {

    @Autowired
    private IOrderProductRepository iOrderProductRepository;

    @Override
    public List<OrderProduct> findAll() {
        return iOrderProductRepository.findAll();
    }
}
