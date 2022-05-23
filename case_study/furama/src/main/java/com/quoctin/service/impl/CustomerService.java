package com.quoctin.service.impl;

import com.quoctin.model.customer.Customer;
import com.quoctin.repository.ICustomerRepository;
import com.quoctin.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllPaging(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }
}
