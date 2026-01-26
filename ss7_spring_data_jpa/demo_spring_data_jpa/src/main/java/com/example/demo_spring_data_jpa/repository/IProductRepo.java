package com.example.demo_customer_orm.repository;

import com.example.demo_customer_orm.entity.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getList();
    boolean add(Product product);
    Product findById(int id);
    boolean edit(Product product);
    boolean deleteById(int id);
    Product detail(int id);
    List<Product> search(String searchName,String searchProduce);
}
