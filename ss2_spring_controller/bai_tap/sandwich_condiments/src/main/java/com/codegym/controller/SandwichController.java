package com.codegym.controller;

import com.codegym.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService iSandwichService;

    @RequestMapping(value = "/home")
    public String home(){
        return "check";
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("result",this.iSandwichService.save(condiment));
        return "final";
    }
}
