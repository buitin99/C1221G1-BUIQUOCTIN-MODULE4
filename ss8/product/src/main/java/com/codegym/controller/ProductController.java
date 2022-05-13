package com.codegym.controller;

import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Dieu huong den controller khi dia chi url tro toi / hoac /home
@RequestMapping({"/","/home"})
public class ProductController {

    // annotation de goi cac @ duoc quan ly boi IOC
    @Autowired
    private IProductService iProductService;




}
