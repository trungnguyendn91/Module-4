package com.codegym.repository;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository <Customer, Integer> {
    Page<Customer> findAllByCustomerNameContainingAndCustomerType_GuestTypeName(String customerName, String guestTypeName, Pageable pageable);
    Page<Customer> findAllByCustomerNameContaining(String customerName, Pageable pageable);
}
