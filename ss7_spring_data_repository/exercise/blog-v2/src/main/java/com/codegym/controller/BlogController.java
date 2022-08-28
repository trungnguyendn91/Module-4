package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

//    @GetMapping ("/")
//    public String list(Model model, @PageableDefault(size =2,
//                        sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
//                       @RequestParam Optional<String> keyword ){
//        String keyWordVal = keyword.orElse("");
//        model.addAttribute("blogList",
//                this.blogService.findAll(keyWordVal, pageable));
//        model.addAttribute("keyWord", keyWordVal);
//                return "blog_list";
//    }
    @GetMapping ("/create")
    public String create(Model model){
        model.addAttribute("blogList", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog,
                       RedirectAttributes redirectAttributes){
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg","Thêm thành công");
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "edit";
    }
    @PostMapping("/update")
    public String edit(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.deleteById(blog.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blogList", blogService.findById(id));
        return "/detail";
    }

    @GetMapping(value = {"", "/", "/search"})
    public String goList(Model model, @PageableDefault(value = 2, sort = "id", direction = Sort.Direction.DESC)
                            Pageable pageable,
                         @RequestParam Optional<String> key, @ModelAttribute("blog") Blog blog) {
            String keyVal = key.orElse("");
        if (blog.getCategory()!=null) {
            model.addAttribute("blogList", blogService.findAllByBlogTitleContainingAndCategory_Id(keyVal,
                    blog.getCategory().getId(), pageable));

        } else {
            model.addAttribute("blogList", blogService.findAllByTitleContaining(keyVal, pageable));
        }
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("keyWord", keyVal);
        model.addAttribute("blog", blog);
        return "blog_list";
    }

}
