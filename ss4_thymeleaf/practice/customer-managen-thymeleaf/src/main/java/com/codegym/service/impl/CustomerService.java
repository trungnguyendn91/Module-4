package com.codegym.service.impl;

import com.codegym.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomer;

import java.util.List;
@Service
public class CustomerService implements ICustomer {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        iCustomerRepository.update(id,customer);

    }

    @Override
    public void remove(int id) {
        iCustomerRepository.remove(id);
    }
}
