package com.codegym.controller;

import com.codegym.model.Medical;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MedicalController {

    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping(value = "/create")
    public String resultMedical(Model model){
        model.addAttribute("medical", new Medical());
        return "home";
    }

    @PostMapping(value = "/create")
    public String updateMedical(@ModelAttribute Medical medical, RedirectAttributes redirectAttributes, Model model){
        this.iMedicalService.update(medical);
        model.addAttribute("medicalList",this.iMedicalService.getMedical());
        return "index";
    }
}
