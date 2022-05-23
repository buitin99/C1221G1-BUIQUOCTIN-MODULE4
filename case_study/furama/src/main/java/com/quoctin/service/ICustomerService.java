package com.quoctin.service;

import com.quoctin.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAllPaging(Pageable pageable);

    void save(Customer customer);
}
