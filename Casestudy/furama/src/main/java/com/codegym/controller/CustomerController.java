package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CustomerController {
    @GetMapping("/customer")
    public String customerList(){
        return "customer/customer_list";
    }
    @GetMapping("/addCustomer")
    public String addCustomerList(){
        return "customer/add_customer";
    }
    @GetMapping("/editCustomer")
    public String editCustomerList(){
        return "customer/customer_edit";
    }
}
