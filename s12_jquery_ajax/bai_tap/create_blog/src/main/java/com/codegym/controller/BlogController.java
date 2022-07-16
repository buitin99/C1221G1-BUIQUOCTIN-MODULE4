package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

//    @Autowired
//    private ICategoryService iCategoryService;

    @Autowired
    private CategoryController categoryController;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 2) Pageable pageable,@RequestParam String name) {
//        Page<Blog> blogPage = this.iBlogService.findAllPaging(pageable);
//        if (!blogPage.hasContent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(blogPage, HttpStatus.OK);
        Page<Blog> blogSeach = iBlogService.findByName(pageable,name);
        if (!blogSeach.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogSeach, HttpStatus.OK);
    }

//    @GetMapping(value = "/list_category")
//    public ResponseEntity<Page<Category>> getPageCategory(@PageableDefault(value = 2) Pageable pageable) {
//        Page<Category> categoryPage = this.iCategoryService.findAllPaging(pageable);
//        if (!categoryPage.hasContent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
//    }

    @GetMapping(value = "/detail")
    public ResponseEntity<Blog> getDetailBlog(@RequestParam Integer id) {
        Blog blogDetail = this.iBlogService.findById(id);
        if (blogDetail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogDetail, HttpStatus.OK);
    }

    @GetMapping(value = "/list_category_blog")
    public ResponseEntity<List<Blog>> getListBlogByIdCategory(@RequestParam Integer id) {
        Category category = categoryController.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.getBlogList(), HttpStatus.OK);
    }

}
