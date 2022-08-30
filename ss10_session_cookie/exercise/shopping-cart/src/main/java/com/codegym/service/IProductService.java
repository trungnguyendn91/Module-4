package com.codegym.service;

import com.codegym.model.Product;

import java.util.Optional;

public interface IProductService {

    Iterable<Product> findAll();

    Product findById(Integer id);
}
