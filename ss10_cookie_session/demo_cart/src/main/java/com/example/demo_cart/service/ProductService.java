package com.example.demo_cart.service;

import com.example.demo_cart.entity.Product;
import com.example.demo_cart.repository.IProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductService implements IProductService {

    private IProductRepo productRepo;

    public ProductService(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public boolean save(Product product) {
        try {
            productRepo.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {

        try {
            productRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> search(String searchName, String searchProduce) {
        return List.of();
    }

    @Override
    public Iterable<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findByIdPro(int id) {
        return productRepo.findById(id);
    }
}
