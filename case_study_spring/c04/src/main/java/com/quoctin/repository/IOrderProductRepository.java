package com.quoctin.repository;

import com.quoctin.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderProductRepository extends JpaRepository<OrderProduct,Integer> {
}
