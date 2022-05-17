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

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goProductList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keywork) {
        String keyworkVal = keywork.orElse("");
//        model.addAttribute("blogLists", this.iBlogService.getList(pageable));
        model.addAttribute("keyworkVal",keyworkVal);
        model.addAttribute("productList",this.iProductService.getProductByName(keyworkVal,pageable));
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.create(product);
        redirectAttributes.addFlashAttribute("msg", "Create new product success!");
        return "redirect:/";
    }

    @RequestMapping(value = "/delete")
    public String deleteProduct(@RequestParam Integer id) {
        Product product = this.iProductService.findById(id);
        this.iProductService.deleteProduct(product);
        return "redirect:/";
    }


    @GetMapping(value = "/edit")
    public String goEdit(Model model,@RequestParam int id){
        model.addAttribute("product",this.iProductService.findById(id));
        return "update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Product product){
        this.iProductService.update(product);
        return "redirect:/";
    }

}
