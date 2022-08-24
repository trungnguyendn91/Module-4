package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findAllByBlogTitleContaining(String blogTitle, Pageable pageable);
//    Page<Blog> findAllByTitleContainingAndCategory_Id(String blogTitle,Integer id, Pageable pageable);
}
