package com.codegym.controller;

import com.codegym.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LibraryController {

    @Autowired
    private ILibraryService iLibraryService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String goBookList(Model model, @PageableDefault (value = 2) Pageable pageable){
//        model.addAttribute("bookList", this.iLibraryService.findAll(pageable));
//        return "list";
//    }
}
