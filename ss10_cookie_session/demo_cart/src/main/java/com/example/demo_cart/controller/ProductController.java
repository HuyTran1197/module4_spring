package com.example.demo_cart.controller;

import com.example.demo_cart.entity.Category;
import com.example.demo_cart.entity.Product;
import com.example.demo_cart.service.ICategoryService;
import com.example.demo_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")

public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/add")
    public String showAdd(Model model){
        model.addAttribute("categoryList",categoryService.findAll());
        model.addAttribute("product",new Product());
        return "product/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Product product,
                       @RequestParam Integer categoryId,
                       RedirectAttributes redirectAttributes){
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
        boolean isSuccess = productService.save(product);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"Add new success":"Add new fail");
        return "redirect:/products";
    }

    @PostMapping("{id}/delete")
    public String deleteById(@PathVariable(name = "id") int deleteId, RedirectAttributes redirectAttributes){
        boolean isSuccess = productService.deleteById(deleteId);
        redirectAttributes.addFlashAttribute("mess",isSuccess ? "delete product success" : "delete product fail");
        return "redirect:/products";
    }

    @GetMapping("{id}/detail")
    public String showDetail(@PathVariable(name = "id") int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/detail";
    }

    @GetMapping("")
    public ModelAndView search(@ModelAttribute Product product){
        List<Product> productList = null;
        if ((product.getName()!=null && !product.getName().isEmpty()||
                (product.getProduce()!=null&&!product.getProduce().isEmpty()))){
            productList = productService.search(product.getName(),product.getProduce());
        }else {
            productList = productService.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("productList",productList);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product,
                       RedirectAttributes redirectAttributes){
        boolean isSuccess = productService.save(product);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"Update product success":"Update product fail");
        return "redirect:/products";
    }
}
