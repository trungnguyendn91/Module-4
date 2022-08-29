package com.codegym.controller;

import com.codegym.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    public class ProductSessionController {
        @GetMapping("/shopping-cart")
        public ModelAndView listCart(@SessionAttribute("cart") Cart carts){
            ModelAndView modelAndView = new ModelAndView("cart");
            modelAndView.addObject("cart",carts);
            return modelAndView;
        }
    }
}
