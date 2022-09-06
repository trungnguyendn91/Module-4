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
@CrossOrigin
@RestController
@RequestMapping (value = "/restBlogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;


    @GetMapping(value = "/list")
    public ResponseEntity<Page<Blog>> findByTitle(@RequestParam(defaultValue = "") String title,@PageableDefault(size = 3)
                                                  Pageable pageable) {
        Page<Blog> blogs = blogService.findAllByTitleContaining(title, pageable);
        if (!blogs.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}/findBlogById")
    public ResponseEntity<Blog> findBlog(@PathVariable Integer id) {
        Blog blog =blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }


}
