package com.example.controller;

import com.example.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculator iCalculator;
    @GetMapping("/")
    public String greeting(){
        return "calculator";
    }

    @GetMapping("/result")
    private String calculator (@RequestParam String number1,
                                @RequestParam String number2,
                                @RequestParam String operator,
                                Model model) {
        try {
            model.addAttribute("result",
                    this.iCalculator.operator(
                            Double.parseDouble(number1),
                            Double.parseDouble(number2),
                            operator) );
        }catch (NumberFormatException n){
          model.addAttribute("result", "Vui lòng nhập số");
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);

    return "calculator";
    }

}
