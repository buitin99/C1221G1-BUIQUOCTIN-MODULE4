package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
//    List<Product> findAll();
//    void create(Product product);
//
////    Product findById(Integer id);
//
//    void delete(Product product);
//
//    void update(Product product);

    Page<Product> findAllByNameContaining(String keyworkVal, Pageable pageable);
}
