package com.codegym.controller;


import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public String list(Model model){
        model.addAttribute("productList",productService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id , @SessionAttribute Cart cart ,
                            @RequestParam("action") String action){
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            return "error.404";
        }
        if(action.equals("show")){
            cart.addProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product.get());
        return "cart";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }
    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable Integer id, @SessionAttribute Cart cart) {
        Optional<Product> product = productService.findById(id);
        if (product == null) {
            return "error.404";
        } else {
            cart.deleteProduct(product.get());
            return "cart";
        }
    }

    @GetMapping("/pay")
    public String payCart( @SessionAttribute Cart cart) {
        cart.getMap().clear();
        return "redirect:/shop";
    }
}