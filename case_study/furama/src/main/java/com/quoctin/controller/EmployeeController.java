package com.quoctin.controller;

import com.quoctin.dto.EmployeeDto;
import com.quoctin.model.employee.Division;
import com.quoctin.model.employee.Education;
import com.quoctin.model.employee.Employees;
import com.quoctin.model.employee.Position;
import com.quoctin.repository.employee.IPositionRepository;
import com.quoctin.service.iemployee.IDivisionService;
import com.quoctin.service.iemployee.IEducationService;
import com.quoctin.service.iemployee.IEmployeeService;
import com.quoctin.service.iemployee.IPositionService;
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
@RequestMapping({"/employee"})
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IEducationService iEducationService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IPositionService iPositionService;

    @ModelAttribute("education")
    public List<Education> educationList() {
        return iEducationService.findAll();
    }

    @ModelAttribute("position")
    public List<Position> positionList() {
        return iPositionService.findAll();
    }

    @ModelAttribute("division")
    public List<Division> divisionList() {
        return iDivisionService.findAll();
    }

    @GetMapping(value = "/list")
    public String getEmployeePage(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Employees> employeesPage = this.iEmployeeService.findAllPaging(pageable);
        model.addAttribute("employee", employeesPage);
        return "employee/employee_list";
    }

    @GetMapping("/create")
    public String showCreateEmployee(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/employee_create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/employee_create";
        } else {
            Employees employees = new Employees();
            BeanUtils.copyProperties(employeeDto, employees);
            iEmployeeService.save(employees);
            return "redirect:list";
        }
    }

    @GetMapping(value = "/update")
    public String showUpdateCustomer(Model model, @RequestParam int id) {
        model.addAttribute("customerDto", this.iEmployeeService.findById(id));
        return "employee/employee_update";
    }

    @PostMapping(value = "/update")
    public String updateCustomer(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "employee/employee_update";
        } else {
            Employees employees = new Employees();
            BeanUtils.copyProperties(employeeDto, employees);
            iEmployeeService.save(employees);
            return "redirect:list";
        }
    }
}
