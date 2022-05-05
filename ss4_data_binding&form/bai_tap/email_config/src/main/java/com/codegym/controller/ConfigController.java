package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ConfigController {

    @Autowired
    private IEmailService iEmailService;

    @GetMapping(value = "/update")
    public String resultEmail(Model model){
        model.addAttribute("email", new Email());
        return "index";
    }

    @PostMapping(value = "/update")
    public String updateEmail(@ModelAttribute Email email, RedirectAttributes redirectAttributes, Model model){
        this.iEmailService.update(email);
        model.addAttribute("email", email);
        redirectAttributes.addFlashAttribute("msg", "Update Success!");
        return "index";
    }
}
