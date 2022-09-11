package com.codegym.service.employee;

import com.codegym.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    void delete(Integer id);
}
