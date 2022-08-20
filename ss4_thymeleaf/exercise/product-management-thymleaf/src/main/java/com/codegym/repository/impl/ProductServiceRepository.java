package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();

    static{
        productList.add(new Product(1,"12 Pro max","Smartphone", "Apple", "USA", 19000000));
        productList.add(new Product(2,"Mac book 14","Laptop", "Apple", "USA", 24000000));
        productList.add(new Product(3,"Air pod 13","Headphone", "Apple", "USA", 10000000));
        productList.add(new Product(4,"Galaxy 20","Smart phone", "Samsung", "Korea", 16000000));
        productList.add(new Product(5,"RedMi Note 14","Smart phone", "Xiaomi", "Taiwan", 12000000));
    }
    @Override
    public List<Product> findAll(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : productList){
            if(p.getProductName().toLowerCase().contains(name.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public void save(Product product) {
       productList.add(product);
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (Product p : productList) {
            if (p.getId() == id) {
                product = p;
            }
        }
        return product;
    }


//    public List<Product> findByName(String name) {
//        List<Product> result = new ArrayList<>();
//        for (Product p : productList){
//            if(p.getProductName().toLowerCase().contains(name.toLowerCase())){
//                result.add(p);
//            }
//        }
//        return result;
//    }


    @Override
    public void update(int id, Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                BeanUtils.copyProperties(product,p);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                productList.remove(productList.get(i));
            }
        }
    }
}
