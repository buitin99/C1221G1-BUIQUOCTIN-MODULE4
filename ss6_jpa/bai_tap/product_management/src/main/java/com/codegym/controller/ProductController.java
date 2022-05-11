package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String goProductList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyworkVal = keyword.orElse("");
        model.addAttribute("keyworkVal", keyworkVal);
        model.addAttribute("productList", this.iProductService.getListByName(keyworkVal, pageable));
        model.addAttribute("productList", this.iProductService.findAll(pageable));
        return "list_product";
    }
//
//    @GetMapping(value = "/create")
//    public String goCreateProduct(Model model) {
//        model.addAttribute("product", new Product());
//        return "create_product";
//    }
//
//    @PostMapping(value = "/create")
//    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
//        this.iProductService.create(product);
//        redirectAttributes.addFlashAttribute("msg", "Create new product success!");
//        return "redirect:/list";
//    }
//
//    @GetMapping(value = "/detail")
//    public String goDetailProduct(@RequestParam Integer id, Model model) {
//        Product product = this.iProductService.findById(id);
//        model.addAttribute("product", product);
//        return "detail_product";
//    }
//
//    @GetMapping(value = "/detail/{id}")
//    public String goDetailProductPV(@PathVariable Integer id, Model model) {
//        Product product = this.iProductService.findById(id);
//        model.addAttribute("product", product);
//        return "detail_product";
//    }
//
//    @RequestMapping(value = "/delete")
//    public String deleteProduct(@RequestParam Integer id) {
//        Product product = this.iProductService.findById(id);
//this.iProductService.deleteProduct(product);
//        return "redirect:/list";
//    }
//
//
//    @GetMapping(value = "/edit")
//    public String goEdit(Model model,@RequestParam int id){
//        model.addAttribute("product",this.iProductService.findById(id));
//        return "update_product";
//    }
//
//    @PostMapping(value = "/update")
//    public String update(@ModelAttribute Product product){
//        this.iProductService.update(product);
//        return "redirect:/list";
//    }


}
