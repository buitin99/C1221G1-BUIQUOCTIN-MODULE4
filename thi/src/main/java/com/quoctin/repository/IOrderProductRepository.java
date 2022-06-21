package com.quoctin.repository;

import com.quoctin.model.OrderProduct;
import com.quoctin.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderProductRepository extends JpaRepository<OrderProduct,Integer> {
    Page<OrderProduct> findAllByDateAfter(String startDay, Pageable pageable);

    Page<OrderProduct> findAllByDateBefore(String endDay, Pageable pageable);

    Page<OrderProduct> findAllByDateBetween(String startDay, String endDay, Pageable pageable);
}
