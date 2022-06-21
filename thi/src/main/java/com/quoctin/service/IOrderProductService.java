package com.quoctin.service;

import com.quoctin.model.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderProductService {
    Page<OrderProduct> find(String startDay, String endDay, Pageable pageable);

    OrderProduct findById(Integer id);

    void save(OrderProduct orderProduct);
}
