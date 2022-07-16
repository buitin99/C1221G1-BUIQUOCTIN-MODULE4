package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private ICategoryService ICategoryRepository;

    @GetMapping(value = "/list_category")
    public ResponseEntity<Page<Category>> getPageCategory(@PageableDefault(value = 2) Pageable pageable) {
        Page<Category> categoryPage = this.iCategoryService.findAllPaging(pageable);
        if (!categoryPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }

    public Category findById(Integer id) {
        return ICategoryRepository.findById(id);
    }
}
