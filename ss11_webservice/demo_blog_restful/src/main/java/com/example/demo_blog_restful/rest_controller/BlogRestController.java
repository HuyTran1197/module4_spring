package com.example.demo_blog_restful.rest_controller;

import com.example.demo_blog_restful.entity.Blog;
import com.example.demo_blog_restful.entity.Category;
import com.example.demo_blog_restful.service.IBlogService;
import com.example.demo_blog_restful.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blogs")
public class BlogRestController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> findAll(@RequestParam(name = "page",defaultValue = "0")int page,
                                              @RequestParam(name = "searchTitle",defaultValue = "")String searchTitle,
                                              @RequestParam(name = "searchCategory",defaultValue = "0")int categoryId){
        Sort sort = Sort.by("title").descending();
        Pageable pageable = PageRequest.of(page,3,sort);
        Page<Blog> blogPage;
        if (categoryId!=0){
            blogPage = blogService.search(categoryId,searchTitle,pageable);
        }else {
            blogPage = blogService.findByTitleContaining(searchTitle,pageable);
        }
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findCategory(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable int id){
        Category category = categoryService.findById(id);
        if (category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
