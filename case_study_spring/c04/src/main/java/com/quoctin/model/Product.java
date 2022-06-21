package com.quoctin.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String status;

    public Product() {
    }

    @ManyToOne
    @JoinColumn(name = "productType_id", referencedColumnName = "id")
    private ProductType productType;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProductList;
}
