package com.example.demo_cart.service;

import com.example.demo_cart.entity.Category;

import java.util.List;

public interface ICategoryService{
    List<Category> findAll();
    Category findById(int id);
}
