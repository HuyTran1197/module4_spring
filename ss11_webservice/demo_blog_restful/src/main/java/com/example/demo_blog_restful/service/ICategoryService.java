package com.example.demo_blog_restful.service;

import com.example.demo_blog_restful.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    boolean save(Category category);
    boolean deleteById(int id);
}
