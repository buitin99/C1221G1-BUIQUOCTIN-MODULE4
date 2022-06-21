package com.quoctin.service.impl;

import com.quoctin.model.OrderProduct;
import com.quoctin.repository.IOrderProductRepository;
import com.quoctin.service.IOrderProductService;
import com.quoctin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService implements IOrderProductService {

    @Autowired
    private IOrderProductRepository iOrderProductRepository;

    @Override
    public Page<OrderProduct> find(String startDay, String endDay, Pageable pageable) {
        Page<OrderProduct> orderProductPage;
        if (startDay == "" && endDay == "") {
            orderProductPage = this.iOrderProductRepository.findAll(pageable);
        } else if (endDay == "") {
            orderProductPage = this.iOrderProductRepository.findAllByDateAfter(startDay, pageable);
        } else if (startDay == "") {
            orderProductPage = this.iOrderProductRepository.findAllByDateBefore(endDay, pageable);
        } else {

            orderProductPage = this.iOrderProductRepository.findAllByDateBetween(startDay, endDay, pageable);
        }
        return orderProductPage;
    }

    @Override
    public OrderProduct findById(Integer id) {
        return iOrderProductRepository.findById(id).orElse(null);
    }

    @Override
    public void save(OrderProduct orderProduct) {
        iOrderProductRepository.save(orderProduct);
    }
}
