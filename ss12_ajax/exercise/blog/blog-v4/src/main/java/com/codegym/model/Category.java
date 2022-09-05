package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;

    @JsonBackReference
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Blog> blog;

    public Category(Integer id, String category, Collection<Blog> blog) {
        this.id = id;
        this.category = category;
        this.blog = blog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public Category(Integer id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Collection<Blog> getBlog() {
        return blog;
    }

    public void setBlog(Collection<Blog> blog) {
        this.blog = blog;
    }

    public Category() {
    }
}
