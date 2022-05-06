package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

}
