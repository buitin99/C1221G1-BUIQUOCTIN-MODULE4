package com.codegym.controller;
import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private IConvertService iConvertService;

    @GetMapping(value = "/goHomePage")
    public String goHomePage(){
        return "homepage";
    }

    @PostMapping(value = "/convert")
    public String convert(@RequestParam Double usd, Model model){
        model.addAttribute("result",this.iConvertService.convert(usd));
       return "resultfinal";
    }


}
