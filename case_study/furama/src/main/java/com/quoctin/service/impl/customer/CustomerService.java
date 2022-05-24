package com.quoctin.service.impl.customer;

import com.quoctin.model.customer.Customer;
import com.quoctin.repository.customer.ICustomerRepository;
import com.quoctin.service.icustomer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> search(String nameSearch, String phoneSearch, String typeSearch) {
        return iCustomerRepository.search("%" + nameSearch  + "%","%" + phoneSearch + "%" ,"%" +  typeSearch + "%");
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepository.delete(customer);
    }


}
