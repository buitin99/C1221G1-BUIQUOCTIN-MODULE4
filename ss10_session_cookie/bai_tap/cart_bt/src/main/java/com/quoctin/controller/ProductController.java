package com.quoctin.controller;

import com.quoctin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping
    public ModelAndView showListPage(Model model){
        return new ModelAndView("list","productList",iProductService.findAll());
    }
}
