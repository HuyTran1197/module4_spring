package com.example.demo_cart.repository;

import com.example.demo_cart.entity.Category;
import com.example.demo_cart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Integer> {

    List<Product> findByNameContainingAndCategoryAndProduce(String searchName, Category searchCategory, String searchProduce);

}
