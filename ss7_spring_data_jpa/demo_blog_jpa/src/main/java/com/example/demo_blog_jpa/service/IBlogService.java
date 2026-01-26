package com.example.demo_blog_jpa.service;

import com.example.demo_blog_jpa.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(int id);
    boolean save(Blog blog);
    boolean deleteById(int id);
    List<Blog> findByTitle(String tile);
}
