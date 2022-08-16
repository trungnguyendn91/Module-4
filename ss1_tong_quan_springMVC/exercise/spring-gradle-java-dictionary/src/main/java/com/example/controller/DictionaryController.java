package com.example.controller;

import com.example.service.ITranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private ITranslate iTranslate;
    @GetMapping("/")
    public String getFormDictionary(){
        return "/dictionary";
    }

    @GetMapping("/result")
    private String translate (@RequestParam String eng, Model model){
        model.addAttribute("eng", eng);
        String result = this.iTranslate.translate(eng);
        if (result!= null) {
            model.addAttribute("result", result);
        }else {
            model.addAttribute("error", "Không tìm thấy");
        }
     return "/dictionary";
    }
}
