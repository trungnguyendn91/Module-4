package com.codegym.blog.model;


import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String blogName;
    @Column (columnDefinition = "text")
    private String blogContent;

    private String blogTitle;

    public Blog() {
    }

    public Blog(Integer id, String blogName, String blogContent, String blogTitle) {
        this.id = id;
        this.blogName = blogName;
        this.blogContent = blogContent;
        this.blogTitle = blogTitle;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
}
