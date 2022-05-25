package com.quoctin.controller;

import com.quoctin.dto.EmployeeDto;
import com.quoctin.dto.FacilityDto;
import com.quoctin.model.employee.Education;
import com.quoctin.model.employee.Employees;
import com.quoctin.model.service.Facility;
import com.quoctin.model.service.FacilityType;
import com.quoctin.model.service.RentType;
import com.quoctin.service.ifacility.IFacilityService;
import com.quoctin.service.ifacility.IFacilityTypeService;
import com.quoctin.service.ifacility.IRentTypeService;
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
@RequestMapping({"/facility"})
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @ModelAttribute("rentType")
    public List<RentType> rentTypeList() {
        return iRentTypeService.findAll();
    }

    @ModelAttribute("facilityType")
    public List<FacilityType> facilityTypeList() {
        return iFacilityTypeService.findAll();
    }


    @GetMapping(value = "/list")
    public String getEmployeePage(Model model, @PageableDefault(value = 14) Pageable pageable) {
        Page<Facility> facilityPage = this.iFacilityService.findAllPaging(pageable);
        model.addAttribute("facility", facilityPage);
        return "facility/facility_list";
    }

    @GetMapping("/create")
    public String showCreateEmployee(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/facility_create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "facility/facility_create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.save(facility);
            return "redirect:list";
        }
    }

    @GetMapping(value = "/update")
    public String showUpdateCustomer(Model model, @RequestParam int id) {
        model.addAttribute("facilityDto", this.iFacilityService.findById(id));
        return "facility/facility_update";
    }

    @PostMapping(value = "/update")
    public String updateCustomer(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "facility/facility_update";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.save(facility);
            return "redirect:list";
        }
    }

}
