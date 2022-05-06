package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class ProductRepository implements IProductRepository {

    static Map<Integer,Product> productMap;

    static {
        productMap = new TreeMap<>();
        productMap.put(1, new Product(1,"Banh",5000.0,"new","Kinh Do"));
        productMap.put(2, new Product(2,"But Chi",15000.0,"new","Hong Ha"));
        productMap.put(3, new Product(3,"Sach",10000.0,"old","Sai Gon"));
        productMap.put(4, new Product(4,"Kem",2000.0,"new","Thu Do"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) {
        Integer id = (int)(Math.random()*10000);
        product.setId(id);
        productMap.put(id,(product));
    }

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public void delete(Integer id) {
        productMap.remove(id);
    }

//    @Override
//    public Product search(String nameSearch) {
//        productMap.entrySet().contains(nameSearch);
//        return Product;
//    }
}
