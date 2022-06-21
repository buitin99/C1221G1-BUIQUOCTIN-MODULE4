package com.quoctin.service;

import com.quoctin.model.OrderProduct;

import java.util.List;

public interface IOrderProductService {
    List<OrderProduct> findAll();
}
