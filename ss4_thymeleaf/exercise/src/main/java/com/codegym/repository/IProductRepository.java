package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save (Product product);

    Product findById(int id);

    List<Product> findByName(String name);

    void update (int id, Product product);

    void remove (int id);
}
