package com.quoctin.controller;

import com.quoctin.dto.ContractDto;
import com.quoctin.dto.CustomerDto;
import com.quoctin.model.contract.Contract;
import com.quoctin.model.customer.Customer;
import com.quoctin.model.customer.CustomerType;
import com.quoctin.model.employee.Employees;
import com.quoctin.model.service.Facility;
import com.quoctin.service.icontract.IContractService;
import com.quoctin.service.icustomer.ICustomerService;
import com.quoctin.service.iemployee.IEmployeeService;
import com.quoctin.service.ifacility.IFacilityService;
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
import java.util.Optional;

@RestController
@Controller
@RequestMapping({"/contract"})
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute("employee")
    public List<Employees> employeeList() {
        return iEmployeeService.findAll();
    }

    @ModelAttribute("customer")
    public List<Customer> customerList() {
        return iCustomerService.findAll();
    }

    @ModelAttribute("facility")
    public List<Facility> facilityList() {
        return iFacilityService.findAll();
    }

    @GetMapping(value = "/list")
    public String searchCustomer(@PageableDefault (value = 2) Pageable pageable,
                                 Model model) {
        Page<Contract> contractPage = this.iContractService.findAll(pageable);
        model.addAttribute("contract", contractPage);
        return "contract/contract_list";
    }

    @GetMapping("/create")
    public String showCreateContract(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "contract/contract_create";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "contract/contract_create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            iContractService.save(contract);
            return "redirect:/contract/list";
        }
    }

}
