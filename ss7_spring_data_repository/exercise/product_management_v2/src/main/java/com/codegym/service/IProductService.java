package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllByName(String name, Pageable pageable);
    void add(Product product);

    void update(Product product);

    Product findById(Integer id);

    void delete(Integer id);
}
