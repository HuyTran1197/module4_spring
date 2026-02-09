package com.example.demo_blog_restful.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private String author;
    private LocalDateTime createBlog;

    @PrePersist
    public void onCreate(){
        this.createBlog = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, String content, String author, LocalDateTime createBlog, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createBlog = createBlog;
        this.category = category;
    }

    public Blog(String title, String content, String author, LocalDateTime createBlog, Category category) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createBlog = createBlog;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreateBlog() {
        return createBlog;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreateBlog(LocalDateTime createBlog) {
        this.createBlog = createBlog;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
