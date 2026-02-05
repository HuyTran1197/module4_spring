package com.example.demo_cart.controller;

import com.example.demo_cart.entity.Cart;
import com.example.demo_cart.entity.Product;
import com.example.demo_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model){
        model.addAttribute("products",productService.getAll());
        return "/shop";
    }

    @GetMapping("/add/{id}")
    public String save(@PathVariable int id,
                       @ModelAttribute Cart cart,
                       @RequestParam("action") String action){
        Optional<Product> productOptional = productService.findByIdPro(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id,
                         Model model){
        Optional<Product> productOptional = productService.findByIdPro(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        Product product = productOptional.get();
        model.addAttribute("product",product);
        return "/detail-shop";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable int id,
                                 @ModelAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findByIdPro(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        cart.removeProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @PostMapping("/cart/update/{id}")
    public String updateCart(@PathVariable int id,
                             @RequestParam("quantity") int quantity,
                             @ModelAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findByIdPro(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        cart.updateProductQuantity(productOptional.get(), quantity);
        return "redirect:/shopping-cart";
    }

}
