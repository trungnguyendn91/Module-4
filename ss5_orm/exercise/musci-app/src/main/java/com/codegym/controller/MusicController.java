package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
@PropertySource("classpath:upload_file.properties")
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping
    public String index(Model model) {

        List<Music> musicList = iMusicService.findAll();

        model.addAttribute("musicList", musicList);

        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {

        ModelAndView modelAndView = new ModelAndView("/create");

        modelAndView.addObject("musicForm", new MusicForm());

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute MusicForm musicForm) {

        MultipartFile multipartFile = musicForm.getLink();

        String fileName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(musicForm.getLink().getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getMusicName(), musicForm.getSingleName(), fileName);
        iMusicService.addMusic(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", musicForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id,Model model){
        model.addAttribute("music", iMusicService.findById(id));
        return "/update";
    }

    @PostMapping("/edit")
    public  String editMusicInfo(@ModelAttribute Music music) {
        iMusicService.update(music);
        return "redirect:/music";

    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id){
        iMusicService.delete(id);
        return "redirect:/music";
    }
}
