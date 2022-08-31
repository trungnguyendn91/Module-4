package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Table
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "blog_title")
    private String blogTitle;
    @Column (name = "blog_content", columnDefinition = "text")
    private String blogContent;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn (name = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Category category) {
        this.category = category;
    }

    public Blog(Integer id, String blogTitle, String blogContent, Category category) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
