package com.example.controller;

import com.example.service.IChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoneyController {
    @Autowired
    private IChangeMoneyService iChangeMoneyService;
    @GetMapping("/")
    public String greeting(){
        return "/ChangeMoney";
    }

    @GetMapping("/result")
    private String changeMoney (@RequestParam int usd, Model model){
        model.addAttribute("usd", usd);
        int vnd = this.iChangeMoneyService.changeMoney(usd);
        model.addAttribute("vnd",vnd);
     return "/ChangeMoney";
    }
}
