package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Rent;
import com.codegym.service.ILibraryService;
import com.codegym.service.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Controller
public class LibraryController {

    @Autowired
    private ILibraryService iLibraryService;

    @Autowired
    private IRentService iRentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goLibraryList(Model model) {
        model.addAttribute("bookLists", this.iLibraryService.getList());
        return "list";
    }

    @GetMapping(value = "/rent")
    public String goEdit(Model model, @RequestParam int id) {
        model.addAttribute("bookLists", this.iLibraryService.findById(id));
        return "rent";
    }

    @PostMapping(value = "/rent")
    public String update(@RequestParam Integer id, Book book, Model model) {
        Book books = iLibraryService.findById(id);
        iLibraryService.save(books);
        Rent rent = new Rent();
        rent.setBook(book);
        iRentService.save(rent);
        return "redirect:/";
    }

    @PostMapping(value = "/give")
    public String give(@RequestParam Long idRent,RedirectAttributes redirectAttributes) {
        Rent rent = this.iRentService.findByCode(idRent);
        this.iRentService.remove(rent);
        this.iLibraryService.returnBook(rent.getBook());
        return "redirect:/";

    }


}
