package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAllByName(String keywordVal, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findCustomerById(Integer id);

    void delete(int id);

    List<CustomerType> findAllTypeCustomer();
}
