package com.quoctin.controller;

import com.quoctin.dto.CustomerDto;
import com.quoctin.model.customer.Customer;
import com.quoctin.model.customer.CustomerType;
import com.quoctin.service.icustomer.ICustomerService;
import com.quoctin.service.icustomer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping({"/customer"})
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerType")
    public List<CustomerType> customerTypeList() {
        return iCustomerTypeService.findAll();
    }


    @GetMapping(value = "/list")
    public String getCustomerPage(Model model, @PageableDefault(value = 14) Pageable pageable) {
        Page<Customer> customerPage = this.iCustomerService.findAllPaging(pageable);
        model.addAttribute("customer", customerPage);
        return "customer/customer_list";
    }

    @GetMapping("/create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create_customer";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "customer/create_customer";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            return "redirect:customer/list";
        }
    }

    @GetMapping(value = "/update")
    public String showUpdateCustomer(Model model, @RequestParam int id) {
        model.addAttribute("customerDto", this.iCustomerService.findById(id));
        return "customer/update_customer";
    }

    @PostMapping(value = "/update")
    public String updateCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "customer/update_customer";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            return "redirect:list";
        }
    }

}
