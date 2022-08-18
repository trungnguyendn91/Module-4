package com.codegym.repository.impl;

import com.codegym.model.Customer;
import org.springframework.stereotype.Service;
import com.codegym.repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerServiceRepository implements ICustomerRepository {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1,new Customer(1,"Vinh","vinh@gmail.com","Quảng Nam"));
        customers.put(2,new Customer(2,"Huy","huy@gmail.com","Đà Nẵng"));
        customers.put(3,new Customer(3,"Thái","thai@gmail.com","Thái Bình"));
        customers.put(4,new Customer(4,"Quỳnh","quynhh@gmail.com","Quảng Ngãi"));
        customers.put(5,new Customer(5,"Nghĩa","nghia@gmail.com","Nha Trang"));
        customers.put(6,new Customer(6,"Sơn","son@gmail.com","Nghệ An"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);

    }

    @Override
    public void remove(int id) {
        customers.remove(id);

    }
}
