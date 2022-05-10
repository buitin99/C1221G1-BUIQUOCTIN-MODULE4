package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categorys")
    public List<Category> categoryList(){
        return iCategoryService.findAll();
    }


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goBlogList(Model model){
        model.addAttribute("blogList", this.iBlogService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateBlog(Model model){
        model.addAttribute("blogList",new Blog());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute Blog blog){
        this.iBlogService.create(blog);
        return "redirect:/";
    }

    @GetMapping(value = "/update")
    public String goUpdateBlog(Model model,@RequestParam Integer id){
        model.addAttribute("blog", this.iBlogService.findById(id));
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateBlog(@ModelAttribute Blog blog){
        this.iBlogService.update(blog);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Integer id){
        Blog blog = iBlogService.findById(id);
        iBlogService.delete(blog);
        return "redirect:/";
    }

    @GetMapping(value = "/detail")
    public String goDetailBlog(@RequestParam Integer id, Model model){
        Blog blog = this.iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }
}
