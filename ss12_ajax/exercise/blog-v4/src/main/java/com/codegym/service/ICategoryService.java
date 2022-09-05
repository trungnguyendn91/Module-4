package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService{
    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    void create(Category category);

    void delete(Integer id);

    Category findById(Integer id);

}
