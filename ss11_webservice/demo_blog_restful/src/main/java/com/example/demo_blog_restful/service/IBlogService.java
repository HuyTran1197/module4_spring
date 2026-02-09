package com.example.demo_blog_restful.service;

import com.example.demo_blog_restful.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface IBlogService {
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    Page<Blog> search(@Param("searchCategory")int categoryId,
                      @Param("searchTitle")String title,
                      Pageable pageable);
    Blog findById(int id);
    boolean save(Blog blog);
    boolean deleteById(int id);
}
