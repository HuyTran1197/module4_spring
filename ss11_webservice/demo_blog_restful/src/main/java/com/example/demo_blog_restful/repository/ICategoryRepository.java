package com.example.demo_blog_restful.repository;

import com.example.demo_blog_restful.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer>{
}
