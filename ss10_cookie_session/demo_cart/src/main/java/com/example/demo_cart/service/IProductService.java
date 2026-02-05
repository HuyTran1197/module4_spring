package com.example.demo_cart.service;

import com.example.demo_cart.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    boolean save(Product product);
    Product findById(int id);
    boolean deleteById(int id);
    List<Product> search(String searchName,String searchProduce);
    Iterable<Product> getAll();
    Optional<Product> findByIdPro(int id);
}
