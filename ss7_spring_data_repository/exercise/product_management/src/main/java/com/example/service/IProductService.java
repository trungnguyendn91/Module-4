package com.example.service;


import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllByName(String name, Pageable pageable);
    void save(Product product);



    Product findById(Integer id);

    void delete(Integer id);
}
