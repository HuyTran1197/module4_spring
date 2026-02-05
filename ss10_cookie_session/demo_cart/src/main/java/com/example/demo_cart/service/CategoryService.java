package com.example.demo_cart.service;

import com.example.demo_cart.entity.Category;
import com.example.demo_cart.repository.ICategoryRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CategoryService implements ICategoryService{

    private ICategoryRepo categoryRepo;

    public CategoryService(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id).orElse(null);
    }
}
