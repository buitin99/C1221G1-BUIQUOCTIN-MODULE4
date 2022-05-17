package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {


    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categorys")
    public List<Category> categoryList() {
        return iCategoryService.findAll();
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goBlogList(Model model, @PageableDefault(value = 2) Pageable pageable,@RequestParam Optional<String> keywork) {
        String keyworkVal = keywork.orElse("");
//        model.addAttribute("blogLists", this.iBlogService.getList(pageable));
        model.addAttribute("keyworkVal",keyworkVal);
        model.addAttribute("blogLists",this.iBlogService.getBlogByName(keyworkVal,pageable));
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateBlog(Model model) {
        model.addAttribute("blogList", new Blog());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.create(blog);
        redirectAttributes.addFlashAttribute("msg", "Create new blog success!");
        return "redirect:/";
    }

    @GetMapping(value = "/update")
    public String goUpdateBlog(Model model, @RequestParam Integer id) {
        model.addAttribute("blog", this.iBlogService.findById(id));
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("msg", "Update new blog success!");
        return "redirect:/";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        Blog blog = iBlogService.findById(id);
        iBlogService.delete(blog);
        redirectAttributes.addFlashAttribute("msg", "Delete blog success!");
        return "redirect:/";
    }

    @GetMapping(value = "/detail")
    public String goDetailBlog(@RequestParam Integer id, Model model) {
        Blog blog = this.iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping(value = "/search")
    public String searchBlog(@RequestParam("search") Optional<String> name,
                             @RequestParam("sort") Optional<String> sort,
                             @PageableDefault(value = 2, sort = {}) Pageable pageable,Model model) {
        String nameSearch = name.orElse("");
        String sortBy = sort.orElse("");
        model.addAttribute("blogLists", this.iBlogService.search(nameSearch,pageable));
        model.addAttribute("sortBy",sortBy);
        model.addAttribute("nameSearch",nameSearch);
        return "list";
    }
}
