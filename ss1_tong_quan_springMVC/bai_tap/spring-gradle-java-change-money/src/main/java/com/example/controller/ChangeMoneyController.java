package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoneyController {
    @GetMapping("/")
    public String greeting(){
        return "/ChangeMoney";
    }

    @GetMapping("/result")
    private String result (@RequestParam int usd, Model model){
        model.addAttribute("usd", usd);
        int vnd = usd*23000;
        model.addAttribute("vnd", vnd );
     return "/ChangeMoney";
    }
}
