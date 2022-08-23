package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.IGeneralRepository;

public interface ICustomerService extends IGeneralService <Customer> {
    boolean insertWithStoredProcedure(Customer customer);
}
