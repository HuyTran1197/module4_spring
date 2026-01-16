package com.example.demo_thymeleaf_product_manager.service;

import com.example.demo_thymeleaf_product_manager.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductService implements IProductService {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone 11", 15000, "128GB", "Apple"));
        productList.add(new Product(2, "iphone 15", 19000, "256GB", "Apple"));
        productList.add(new Product(3, "SamSung Note 10", 19000, "256GB", "SamSung"));
    }

    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public boolean add(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                System.out.println("id's product is already exists");
                return false;
            }
        }
        return productList.add(product);
    }

    @Override
    public boolean edit(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()== product.getId()){
                productList.set(i,product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        boolean isSuccess = false;
        for (Product p : productList) {
            if (p.getId() == id) {
                productList.remove(p);
                isSuccess = true;
                break;
            }
        }
        return isSuccess;
    }

    @Override
    public Product detail(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> search(String searchName, String searchProduce) {
        List<Product> result = new ArrayList<>();

        for (Product p : getList()) {

            boolean matchName = true;
            boolean matchProduce = true;

            if (searchName != null && !searchName.trim().isEmpty()) {
                matchName = p.getName()
                        .toLowerCase()
                        .contains(searchName);
            }
            if (searchProduce != null && !searchProduce.trim().isEmpty()) {
                matchProduce = p.getProduce()
                        .equalsIgnoreCase(searchProduce);
            }
            if (matchName && matchProduce) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Product findById(int id){
        return productList.get(id);
    }
}
