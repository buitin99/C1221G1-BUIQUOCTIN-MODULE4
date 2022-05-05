package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView goMusicList(){

        ModelAndView modelAndView = new ModelAndView("show_list");
        modelAndView.addObject("musicList",this.iMusicService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/upload")
    public String goUploadMusic(Model model){
        model.addAttribute("music",new Music());
        return "upload_music";
    }

    @PostMapping(value = "/upload")
    public String createMusic(@ModelAttribute Music music, RedirectAttributes redirectAttributes){
        this.iMusicService.upload(music);
        redirectAttributes.addFlashAttribute("msg","Upload successfully!");
        return "redirect:/list";
    }

}
