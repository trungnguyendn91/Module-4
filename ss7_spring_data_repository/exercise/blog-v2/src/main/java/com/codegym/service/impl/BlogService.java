package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(String blogTitle, Pageable pageable) {
        return this.blogRepository.findAllByBlogTitleContaining(blogTitle, pageable);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        this.blogRepository.deleteById(id);

    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

   @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByBlogTitleContaining(title, pageable);
    }

    @Override
   public Page<Blog> findAllByBlogTitleContainingAndCategory_Id(String blogTitle, Integer id, Pageable pageable) {
        return blogRepository.findAllByBlogTitleContainingAndCategory_Id(blogTitle, id, pageable);
    }


}
