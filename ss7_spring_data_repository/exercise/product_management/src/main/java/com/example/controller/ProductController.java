package com.example.controller;



import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping(value = {"/search", ""})
    public String searchByName(@RequestParam(defaultValue = "") String name, Model model,
                               @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("productList", productService.findAllByName(name,pageable));
        model.addAttribute("size",pageable.getPageSize());
        return "/list_product";
    }
    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("productList", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Add complete");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String goUpdate(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("productList", product);
        return "/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg", "update complete");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "delete complete");
        return "redirect:/";
    }
    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("productList", product);
        return "/detail";
    }

}
