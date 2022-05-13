package com.codegym.controller;

import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goProductList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyworkVal = keyword.orElse("");
        model.addAttribute("keyworkVal", keyworkVal);
        model.addAttribute("productList", this.iProductService.getListByName(keyworkVal, pageable));
        return "list_product";
    }

    @GetMapping(value = "/create")
    public String goCreateProduct(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "create_product";
    }

    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult
            , RedirectAttributes redirectAttributes, Model model) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Create new product fail!");
            return "create_product";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            this.iProductService.save(product);
            redirectAttributes.addFlashAttribute("msg", "Create new product success!");
            return "redirect:/";
        }
    }


//    @RequestMapping(value = "/delete")
//    public String deleteProduct(@RequestParam Integer id) {
//        Product product = this.iProductService.findById(id);
//        this.iProductService.deleteProduct(product);
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
