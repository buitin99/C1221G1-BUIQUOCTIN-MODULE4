package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByNameContaining(String nameSearch, Pageable pageable);

    @Query(value = "select * from product where name like :nameSearch and describer like :desSearch and category_id like :typeSearch ", nativeQuery = true)
    Page<Product> findProductCustom(@Param("nameSearch") String nameSearch, @Param("desSearch") String desSearch, @Param("typeSearch") String typeSearch,Pageable pageable);

}
