package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.Song;
import com.codegym.service.ISongService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goSongList(Model model,@PageableDefault (value = 2) Pageable pageable){
        model.addAttribute("songList",this.iSongService.findAll(pageable));
        return "list";
    }

    @GetMapping(value = "/edit")
    public String goEdit(Model model,@RequestParam int id){
        model.addAttribute("songDto",this.iSongService.findById(id));
        return "update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "update";
        }
        else{
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            return "redirect:/";
        }
    }

}
