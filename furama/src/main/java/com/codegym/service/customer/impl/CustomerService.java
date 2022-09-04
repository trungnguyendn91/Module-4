package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.repository.ICustomerRepository;
import com.codegym.repository.ICustomerTypeRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public Page<Customer> findAll(String customerName, String typeCustomer, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContainingAndCustomerType_GuestTypeName(customerName, typeCustomer, pageable);
    }

    @Override
    public Page<Customer> findAllByCustomerName(String customerName, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(customerName, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(findCustomerById(id));
    }

    @Override
    public List<CustomerType> findAllTypeCustomer() {
        return iCustomerTypeRepository.findAll();
    }
}
