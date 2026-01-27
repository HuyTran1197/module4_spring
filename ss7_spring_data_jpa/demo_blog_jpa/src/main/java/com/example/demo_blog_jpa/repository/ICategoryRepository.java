package com.example.demo_blog_jpa.repository;

import com.example.demo_blog_jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer>{
}
