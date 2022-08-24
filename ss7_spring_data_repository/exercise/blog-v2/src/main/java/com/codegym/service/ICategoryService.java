package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICategoryService{
    List<Category> findAll();

    void create(Category category);

    void delete(Integer id);

    Category findById(Integer id);

}
