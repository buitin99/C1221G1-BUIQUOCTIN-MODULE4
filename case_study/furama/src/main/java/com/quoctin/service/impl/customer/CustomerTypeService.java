package com.quoctin.service.impl.customer;

import com.quoctin.model.customer.CustomerType;
import com.quoctin.repository.customer.ICustomerTypeRepository;
import com.quoctin.service.icustomer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
