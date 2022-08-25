package com.codegym.controller;

import com.codegym.dto.MusicDTO;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("listMusic", musicService.findAll());
        return "music_list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music", new MusicDTO());
        return "create";
    }

    @PostMapping("/createMusic")
    public String save(@ModelAttribute(name = "music") @Valid MusicDTO musicDto,
                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto,music);
        musicService.save(music);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam int id, Model model){
        model.addAttribute("listMusic", musicService.findById(id));
        return "update";
    }

    @PostMapping("/editMusic")
    public String update(@ModelAttribute(name = "listMusic") @Valid MusicDTO musicDto,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "update";
        }
        Music music = new Music();
        music.setId(musicDto.getId());
        BeanUtils.copyProperties(musicDto,music);
        musicService.save(music);
        return "redirect:/";
    }
}
