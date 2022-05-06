package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String goProductList(Model model) {
        model.addAttribute("productList", this.iProductService.findAll());
        return "list_product";
    }

    @GetMapping(value = "/create")
    public String goCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create_product";
    }

    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.create(product);
        redirectAttributes.addFlashAttribute("msg", "Create new product success!");
        return "redirect:/list";
    }

    @GetMapping(value = "/detail")
    public String goDetailProduct(@RequestParam Integer id, Model model) {
        Product product = this.iProductService.findById(id);
        model.addAttribute("product", product);
        return "detail_product";
    }

    @GetMapping(value = "/detail/{id}")
    public String goDetailProductPV(@PathVariable Integer id, Model model) {
        Product product = this.iProductService.findById(id);
        model.addAttribute("product", product);
        return "detail_product";
    }

    @RequestMapping(value = "/delete")
    public String deleteProduct(@RequestParam Integer id) {
        this.iProductService.deleteProduct(id);
        return "redirect:/list";
    }

//    @PostMapping(value = "/search")
//    public String searchProduct(@RequestParam String nameSearch, Model model){
//        Product product = this.iProductService.search(nameSearch);
//        model.addAttribute("product",product);
//        return "search_product";
//    }


    @GetMapping("/update")
    public String goUpdateProduct(@RequestParam Integer id, Model model) {
        Product product = this.iProductService.findById(id);
        model.addAttribute("product", product);
        return "update_product";
    }

    @PostMapping(value = "/update")
    public String updateProduct(@RequestParam Integer id,@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.update(id,product);
        redirectAttributes.addFlashAttribute("msg", "Update new product success!");
        return "redirect:/list";
    }


}
