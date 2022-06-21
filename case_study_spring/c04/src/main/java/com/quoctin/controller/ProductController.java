package com.quoctin.controller;

import com.quoctin.model.OrderProduct;
import com.quoctin.model.Product;
import com.quoctin.model.ProductType;
import com.quoctin.service.IOrderProductService;
import com.quoctin.service.IProductService;
import com.quoctin.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/product"})
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IProductTypeService iProductTypeService;

    @Autowired
    private IOrderProductService iOrderProductService;


    @ModelAttribute("productType")
    public List<ProductType> productTypeList() {
        return iProductTypeService.findAll();
    }

    @ModelAttribute("orderProduct")
    public List<OrderProduct> orderProductList() {
        return iOrderProductService.findAll();
    }

//    @GetMapping(value = "/list")
//    public String searchCustomer(@PageableDefault(value = 2) Pageable pageable,
//                                 @RequestParam("name") Optional<String> name,
//                                 @RequestParam("phone") Optional<String> phone,
//                                 @RequestParam("type") Optional<String> type,
//                                 Model model) {
//        String nameSearch = name.orElse("");
//        String phoneSearch = phone.orElse("");
//        String typeSearch = type.orElse("");
//        if(type.isPresent()){
//            if("-1".equals(type.get())){
//                typeSearch = "";
//            }else{
//                typeSearch= type.get();
//            }
//        }else{
//            typeSearch="";
//        }
//        Page<Customer> customerPage = this.iCustomerService.search(nameSearch, phoneSearch, typeSearch,pageable);
//        model.addAttribute("customer", customerPage);
//        return "customer/customer_list";
//    }

        @GetMapping(value = "/list")
        public String productList(@PageableDefault (value = 2) Pageable pageable,
                Model model) {
            Page<Product> productPage = this.iProductService.findAll(pageable);
            model.addAttribute("product", productPage);
            return "list";
        }
}
