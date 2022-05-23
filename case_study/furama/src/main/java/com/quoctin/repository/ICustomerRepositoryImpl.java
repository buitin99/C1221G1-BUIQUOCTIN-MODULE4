package com.quoctin.repository;

import com.quoctin.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepositoryImpl extends JpaRepository<Customer,Integer> {
}
