package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping ("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping(value = {"", "/search"})
    public String showCustomer(Model model, @PageableDefault(value = 2) Pageable pageable,
                               @RequestParam Optional<String> key,
                               @ModelAttribute("customer") Customer customer){
        String keyName = key.orElse("");
        if (customer.getCustomerType()!=null){
            model.addAttribute("customerList", customerService.findAll(keyName,
                    customer.getCustomerType().getGuestTypeName(), pageable));
        }else {
            model.addAttribute("customerList",customerService.findAllByCustomerName(keyName,pageable));
        }
        model.addAttribute("guestTypeList", customerService.findAllTypeCustomer());
        model.addAttribute("keyWord", keyName);
        model.addAttribute("customer", customer);
        return "/customer/customer_list";
    }
    @GetMapping("/create")
    public String goAddFormCustomer(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("guestTypeList",customerService.findAllTypeCustomer());
        return "/customer/add_customer";
    }
    @PostMapping("/save")
    public String addNewCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/customers/";
    }

    @GetMapping("/formEdit")
    public String showEditCustomerForm(@RequestParam Integer id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        model.addAttribute("guestTypeList",customerService.findAllTypeCustomer());
        return "/customer/customer_edit";
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers/";
    }
    @PostMapping("/delete")
    public String delete(int id) {
        customerService.delete(id);
        return "redirect:/customers/";
    }
}
