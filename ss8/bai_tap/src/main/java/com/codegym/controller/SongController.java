package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute @Validated SongDto songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            redirectAttributes.addFlashAttribute("message", "Create Song fail!");
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("message", "create song Success!");
            return "redirect:/list";
        }
    }

}
