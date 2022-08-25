package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IBlogService {

    Page<Blog> findAll(String blogTitle, Pageable pageable);

    void save(Blog blog);
    void deleteById(Integer id);

    Blog findById(Integer id);
   Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByBlogTitleContainingAndCategory_Id(String blogTitle,Integer id, Pageable pageable);
}
