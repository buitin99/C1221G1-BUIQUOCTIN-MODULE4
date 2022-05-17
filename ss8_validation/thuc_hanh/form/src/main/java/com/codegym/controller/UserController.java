package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showUsersList(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("list", "usersList", this.iUserService.findAll(pageable));
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute @Validated UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            redirectAttributes.addFlashAttribute("message", "Create User fail!");
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("message", "create user: " + user.getFirstName() + " Success!");
            return "redirect:/list";
        }
    }

}
