package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Banh",5000.0,"new","Kinh Do"));
        productList.add(new Product(2,"But Chi",15000.0,"new","Hong Ha"));
        productList.add(new Product(3,"Sach",10000.0,"old","Sai Gon"));
        productList.add(new Product(4,"Kem",2000.0,"new","Thu Do"));
    }

    public Integer idAutoIncrement(){
        return productList.size()+1;
    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        product.setId(idAutoIncrement());
        productList.add(product);
    }

    @Override
    public Product findById(Integer id) {

    }
}
