package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ProductServiceRepository implements IProductRepository {
    private final String FIND_ALL = "select p from Product p where lower(p.productName) like lower(:name)";
    private final String FIND_BY_ID = "select p from Product p where p.id = :productId";


    @Override
    public List<Product> findAll(String name) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery(FIND_ALL, Product.class);
        typedQuery.setParameter("name", "%" + name + "%");
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery(FIND_BY_ID, Product.class);
        typedQuery.setParameter("productId", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }
}
