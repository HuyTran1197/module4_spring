package com.example.demo_cart.entity;


import java.util.HashMap;
import java.util.Map;

public class Cart {
   private Map<Product,Integer> productIntegerMap = new HashMap<>();

    public Cart() {
    }
    public Cart(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    public Map<Product,Integer> getProduct(){
        return productIntegerMap;
    }

    private boolean checkItemsInCart(Product product){
        for (Map.Entry<Product,Integer> entry: productIntegerMap.entrySet()){
            if (entry.getKey().getId()== product.getId()){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product,Integer> selectItemsInCart(Product product){
        for (Map.Entry<Product,Integer> entry: productIntegerMap.entrySet()){
            if (entry.getKey().getId()== product.getId()){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemsInCart(product)){
            productIntegerMap.put(product,1);
        }else {
            Map.Entry<Product,Integer> itemsEntry = selectItemsInCart(product);
            Integer newQuantity = itemsEntry.getValue() + 1;
            productIntegerMap.replace(itemsEntry.getKey(),newQuantity);
        }
    }


    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return productIntegerMap.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public void removeProduct(Product product) {
        if (checkItemsInCart(product)) {
            productIntegerMap.remove(selectItemsInCart(product).getKey());
        }
    }

    public void updateProductQuantity(Product product, int quantity) {
        if (quantity <= 0) {
            removeProduct(product);
        } else {
            if (checkItemsInCart(product)) {
                Map.Entry<Product, Integer> itemsEntry = selectItemsInCart(product);
                productIntegerMap.replace(itemsEntry.getKey(), quantity);
            } else {
                productIntegerMap.put(product, quantity);
            }
        }
    }

}
