package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping (value = "/restBlogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<Blog>> goList(@PageableDefault(value = 2, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable) {
        Page<Blog> blogPage = this.blogService.findAll(pageable);
       if (!blogPage.hasContent()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping (value = "/categoryList")
    ResponseEntity<Page<Category>> categoryList (Pageable pageable){
        Page<Category> categoryPage = this.categoryService.findAll(pageable);
        if (!categoryPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }

    @GetMapping("/{id}/findBlogById")
    public ResponseEntity<Blog> findBlog(@PathVariable Integer id) {
        Blog blog =blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/{id}/findCategoryById")
    public ResponseEntity<Category> findCategory(@PathVariable Integer id) {
        Category category =categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
