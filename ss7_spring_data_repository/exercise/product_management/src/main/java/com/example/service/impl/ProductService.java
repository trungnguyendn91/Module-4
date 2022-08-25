package com.example.service.impl;


import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Page<Product> findAllByName(String name, Pageable pageable) {
        return productRepository.findAllByProductNameContaining(name, pageable);
    }

    @Override
    public void save (Product product) {
        productRepository.save(product);

    }


    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
