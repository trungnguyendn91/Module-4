package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProduct;
import com.codegym.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProduct productService = new ProductService();

    @GetMapping
    public String index(Model model, String name){
        List<Product> productList = productService.findAll(name);
        model.addAttribute("products",productList);
        return"/index";
    }

    @GetMapping ("/create")
    public String create(Model model){
        model.addAttribute("products", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("msg","Thêm thành công");
        return "redirect:/products";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/products";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "/view";
    }

//    @GetMapping("/search")
//    public String search (String name, Model model){
//        if (name!=null){
//            List<Product> productList = productService.findByName(name);
//            model.addAttribute("products",productList);
//        }else {
//            model.addAttribute("products",productService.findAll());
//        }
//
//        return "/index";
//    }
}
