package com.quoctin.controller;

import com.quoctin.dto.CustomerDto;
import com.quoctin.model.customer.Customer;
import com.quoctin.model.customer.CustomerType;
import com.quoctin.service.ICustomerService;
import com.quoctin.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<CustomerType> customerTypeList(){
        return iCustomerTypeService.findAll();
    }



    @GetMapping(value = "/list")
    public String getCustomerPage(Model model, @PageableDefault(value = 2)Pageable pageable){
        Page<Customer> customerPage = this.iCustomerService.findAllPaging(pageable);
        model.addAttribute("customer",customerPage);
        return "customer_list";
    }

    @GetMapping("/create")
    public String showCreateCustomer(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        return "create_customer";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model){
        new CustomerDto().validate(customerDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "create_customer";
        }else
        {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            iCustomerService.save(customer);
            return "redirect:list";
        }
    }

}
