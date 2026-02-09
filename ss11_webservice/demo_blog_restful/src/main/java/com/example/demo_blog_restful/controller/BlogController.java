package com.example.demo_blog_restful.controller;


import com.example.demo_blog_restful.entity.Blog;
import com.example.demo_blog_restful.entity.Category;
import com.example.demo_blog_restful.service.IBlogService;
import com.example.demo_blog_restful.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public String showBlog(Model model,
                           @RequestParam(name = "page",defaultValue = "0")int page,
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
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("searchTitle",searchTitle);
        model.addAttribute("searchCategory",categoryId);
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

    @GetMapping("category/add")
    public String showFormAddCtg(Model model){
        model.addAttribute("category",new Category());
        return "blog/add-category";
    }

    @PostMapping("category/add")
    public String saveCategory(@ModelAttribute Category category,
                               RedirectAttributes redirectAttributes){

        boolean isSuccess = categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"Tạo danh mục thành công":"Tạo danh mục không thành công");
        return "redirect:/blog/category";
    }

    @GetMapping("category/{id}/update")
    public String showFormUpdateCtg(@PathVariable(name = "id")int id,
                                 Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "/blog/update-category";
    }
    @PostMapping("category/update")
    public String updateCtg(@ModelAttribute Category category,
                            RedirectAttributes redirectAttributes){
        boolean isSuccess = categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"Cập nhật danh mục thành công":"Cập nhật danh mục không thành công");

        return "redirect:/blog/category";

    }

    @PostMapping("/category/{id}/delete")
    public String deleteCtgById(@PathVariable(name = "id")int id,
                                RedirectAttributes redirectAttributes){
        boolean isSuccess = categoryService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"Xóa danh mục thành công":"Xóa danh mục không thành công");
        return "redirect:/blog/category";

    }
}
