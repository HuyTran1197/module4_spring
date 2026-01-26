package com.example.demo_customer_orm.service;

import com.example.demo_customer_orm.entity.Product;
import com.example.demo_customer_orm.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> getList() {
        return productRepo.getList();
    }

    @Override
    public boolean add(Product product) {
        for (Product p : getList()) {
            if (p.getId() == product.getId()) {
                System.out.println("id's product is already exists");
                return false;
            }
        }
        return productRepo.add(product);
    }

    @Override
    public boolean edit(Product product) {
        return productRepo.edit(product);
    }

    @Override
    public boolean deleteById(int id) {
        return productRepo.deleteById(id);
    }

    @Override
    public Product detail(int id) {
//        for (Product p : getList()) {
//            if (p.getId() == id) {
//                return p;
//            }
//        }
//        return null;
        return productRepo.detail(id);
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
        return productRepo.findById(id);
    }
}
