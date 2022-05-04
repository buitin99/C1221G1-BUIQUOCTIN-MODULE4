package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String calculator(@RequestParam Integer number1,@RequestParam Integer number2,@RequestParam String
            calculation, Model model) {
        model.addAttribute("result", this.iCalculatorService.calculate(number1, number2, calculation));
        return "result";
    }
}
