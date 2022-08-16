package com.example.controller;

import com.example.service.ICondiments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentsController {
    @Autowired
    private ICondiments iCondiments;
    @GetMapping("/")
    public String selectList(Model model){
        model.addAttribute("condiments", this.iCondiments.findAllCondiments());
        return "/condimentsList";
    }

    @GetMapping("/save")
    public String save(@RequestParam(required = false) String[] condiments, Model model) {
        if (condiments == null){
            model.addAttribute("message", "Please choose seasoning");
        }else {
            model.addAttribute("select", this.iCondiments.saveCondiments(condiments));
        }
        model.addAttribute("condiments", this.iCondiments.findAllCondiments());
        return "/condimentsList";
    }
}
