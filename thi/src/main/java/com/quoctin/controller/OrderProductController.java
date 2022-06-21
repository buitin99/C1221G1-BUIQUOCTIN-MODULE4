package com.quoctin.controller;

import com.quoctin.dto.OrderProductDto;
import com.quoctin.model.OrderProduct;
import com.quoctin.model.Product;
import com.quoctin.model.ProductType;
import com.quoctin.service.IOrderProductService;
import com.quoctin.service.IProductService;
import com.quoctin.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/order"})
public class OrderProductController {

    @Autowired
    private IOrderProductService iOrderProductService;

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IProductTypeService iProductTypeService;

    @ModelAttribute("product")
    public List<Product> orderProductList() {
        return iProductService.findAll();
    }

    @ModelAttribute("productType")
    public List<ProductType> productTypeList() {
        return iProductTypeService.findAll();
    }


    @GetMapping(value = "/home")
    public String homePage(){
        return "/web/theme/bs/full-img-cover";
    }


    @GetMapping(value = "/list")
    public String orderList(@PageableDefault(value = 2,sort = {}) Pageable pageable,
                            @RequestParam("dayStart") Optional<String> start,
                            @RequestParam("dayEnd") Optional<String> end,
                            Model model,
                            @RequestParam Optional<String> sort) {
        String startDay = start.orElse("");
        String endDay = end.orElse("");
        String sortBy = sort.orElse("");
        Page<OrderProduct> orderProductPage = this.iOrderProductService.find(startDay, endDay,pageable);
        model.addAttribute("start",startDay);
        model.addAttribute("end",endDay);
        model.addAttribute("orders", orderProductPage);
        model.addAttribute("sortBy", sortBy);
        return "web/list";
    }

    @GetMapping(value = "/update")
    public String updateOrderList(Model model, @RequestParam Integer id) {
        model.addAttribute("orderProductDto", this.iOrderProductService.findById(id));
        return "web/update";
    }

    @PostMapping(value = "/update")
    public String editOrderList(@ModelAttribute @Validated OrderProductDto orderProductDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "web/update";
        } else {
            OrderProduct orderProduct = new OrderProduct();
            BeanUtils.copyProperties(orderProductDto, orderProduct);
            iOrderProductService.save(orderProduct);
            return "redirect:list";
        }
    }
}
