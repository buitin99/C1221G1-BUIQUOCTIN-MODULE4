package com.quoctin.controller;

import com.quoctin.model.customer.Customer;
import com.quoctin.service.ICustomerServiceImpl;
import com.quoctin.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CustomerController {

    @Autowired
    private ICustomerServiceImpl iCustomerService;

//    @GetMapping(value = "/list")
//    public ResponseEntity<Page<Customer>> getCustomerPage(@PageableDefault(value = 2)Pageable pageable){
//
//    }

}
