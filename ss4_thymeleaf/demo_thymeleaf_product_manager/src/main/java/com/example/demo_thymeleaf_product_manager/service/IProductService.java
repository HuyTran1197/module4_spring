package com.example.demo_thymeleaf_product_manager.service;

import com.example.demo_thymeleaf_product_manager.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();
    boolean add(Product product);
    Product findById(int id);
    boolean edit(Product product);
    boolean deleteById(int id);
    Product detail(int id);
    List<Product> search(String searchName,String searchProduce);
}
