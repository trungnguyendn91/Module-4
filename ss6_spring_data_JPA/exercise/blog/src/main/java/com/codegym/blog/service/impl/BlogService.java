package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return this.iBlogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public void save(Blog blogObj) {
        this.iBlogRepository.save(blogObj);
    }

    @Override
    public void deleteById(Integer id) {
        this.iBlogRepository.findById(id);
    }
}
