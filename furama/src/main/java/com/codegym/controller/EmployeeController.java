package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @GetMapping("/employee")
    public String employeeList(){
        return "employee/employee_list";
    }
    @GetMapping("/editEmployee")
    public String editEmployee(){
        return "employee/edit_employee";
    }
    @GetMapping("/addEmployee")
    public String addEmployee(){
        return "employee/add_employee";
    }
}
