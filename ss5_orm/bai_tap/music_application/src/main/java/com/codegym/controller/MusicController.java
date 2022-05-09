package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String goListMusic(Model model) {
        model.addAttribute("musicList", this.iMusicService.findAll());
        return "list_music";
    }

    @GetMapping(value = "/create")
    public String goCreateMusic(Model model) {
        model.addAttribute("music", new Music());
        return "create_music";
    }

    @PostMapping(value = "/create")
    public String createMusic(@ModelAttribute Music music) {
        this.iMusicService.create(music);
        return "redirect:/list";
    }

    @GetMapping(value = "/update")
    public String goUpdateMusic(Model model, @RequestParam Integer id) {
        model.addAttribute("music", this.iMusicService.findById(id));
        return "update_music";
    }

    @PostMapping(value = "/update")
    public String updateMusic(@ModelAttribute Music music) {
        this.iMusicService.update(music);
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Integer id) {
        Music music = iMusicService.findById(id);
        iMusicService.delete(music);
        return "redirect:/list";
    }
}
