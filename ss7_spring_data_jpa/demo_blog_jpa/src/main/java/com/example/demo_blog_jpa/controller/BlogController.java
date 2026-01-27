package com.example.demo_blog_jpa.controller;


import com.example.demo_blog_jpa.entity.Blog;
import com.example.demo_blog_jpa.entity.Category;
import com.example.demo_blog_jpa.service.IBlogService;
import com.example.demo_blog_jpa.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blog")
public class BlogController {

    private final IBlogService blogService;
    private final ICategoryService categoryService;

    public BlogController(IBlogService BlogService, ICategoryService categoryService) {
        this.blogService = BlogService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String showBlog(Model model){
        model.addAttribute("blogList",blogService.findAll());
        model.addAttribute("categoryList",categoryService.findAll());
        return "blog/form";
    }

    @GetMapping("/category")
    public String showCategory(Model model){
        model.addAttribute("categoryList",categoryService.findAll());
        return "blog/category";
    }

    @GetMapping("{id}/detail")
    public String read(@PathVariable(name = "id") int id,
                       Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/detail";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "blog/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Blog blog,
                       @RequestParam Integer categoryId,
                       RedirectAttributes redirectAttributes){
        Category category = categoryService.findById(categoryId);
        blog.setCategory(category);
        boolean isSuccess = blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"Tạo blog mới thành công":"Tạo blog mới không thành công");
        return  "redirect:/blog";
    }

    @GetMapping("{id}/update")
    public String showFormUpdate(@PathVariable(name = "id") int id,
                                 Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("categoryList",categoryService.findAll());
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,
                         @RequestParam Integer categoryId,
                       RedirectAttributes redirectAttributes){
        Category category = categoryService.findById(categoryId);
        blog.setCategory(category);
        boolean isSuccess = blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"Cập nhật thành công":"Cập nhật không thành công");
        return  "redirect:/blog";
    }

    @PostMapping("{id}/delete")
    public String deleteById(@PathVariable(name = "id") int id,
                             RedirectAttributes redirectAttributes){
        boolean isSuccess = blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"Xóa blog thành công":"Xóa không thành công");
        return "redirect:/blog";
    }

}
