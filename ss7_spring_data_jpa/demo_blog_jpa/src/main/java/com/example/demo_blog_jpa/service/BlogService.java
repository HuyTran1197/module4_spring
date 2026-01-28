package com.example.demo_blog_jpa.service;

import com.example.demo_blog_jpa.entity.Blog;
import com.example.demo_blog_jpa.repository.IBlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BlogService implements IBlogService{

    private IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    @Override
    public Page<Blog> findByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Page<Blog> search(int categoryId, String title, Pageable pageable) {
        return blogRepository.search(categoryId,"%"+title+"%", pageable);
    }


    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Blog blog) {
        try {
            blogRepository.save(blog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            blogRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
