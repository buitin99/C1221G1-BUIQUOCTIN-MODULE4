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

import java.util.Optional;

@Controller
//Dieu huong den controller khi dia chi url tro toi / hoac /home
@RequestMapping({"/", "/home"})
public class ProductController {

    // annotation de goi cac @ duoc quan ly boi IOC
    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goProductList(@RequestParam("name") Optional<String> name, @PageableDefault(value = 2, sort = {}) Pageable pageable,
                                Model model,  @RequestParam Optional<String> sort) {
        String nameSearch = name.orElse("");
        String sortBy = sort.orElse("");
        model.addAttribute("productList", this.iProductService.findByNameContaining(nameSearch,pageable));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("sortBy", sortBy);
        return "list";
    }

    @GetMapping("/create")
    public String showFormcreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }


    @PostMapping("/create")
    public String createProduct(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult
            , RedirectAttributes redirectAttributes, Model model) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            redirectAttributes.addFlashAttribute("message", "Create Song fail!");
            return "create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("message", "create song Success!");
            return "redirect:/";
        }
    }
}
