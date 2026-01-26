package com.example.demo_blog_jpa.repository;

import com.example.demo_blog_jpa.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    List<Blog> findByTitleContaining(String title);

}
