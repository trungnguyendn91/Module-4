package com.codegym.controller;

import com.codegym.dto.CustomerDto.CustomerDto;
import com.codegym.dto.CustomerDto.CustomerTypeDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping ("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = {"", "/search"})
    public String showCustomer(Model model, @RequestParam Optional<String> key,
                               @PageableDefault(size = 5) Pageable pageable) {
        String keyword = key.orElse("");
        model.addAttribute("typeList", customerService.findAllTypeCustomer());
        model.addAttribute("customerList", customerService.findAllByName(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "/customer/customer_list";
    }
    @GetMapping("/create")
    public String goAddFormCustomer(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("guestTypeList",customerService.findAllTypeCustomer());
        return "/customer/add_customer";
    }
    @PostMapping("/save")
    public String addNewCustomer(@ModelAttribute (value = "customerDto") @Valid CustomerDto customerDto,
                                 BindingResult bindingResult, RedirectAttributes redirect,
                                 Model model){
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("guestTypeList", customerService.findAllTypeCustomer());
            return "/customer/add_customer";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        CustomerType customerType = new CustomerType();
        customerType.setIdGuestType(customerDto.getCustomerType().getIdGuestType());
        customer.setCustomerType(customerType);

        customerService.save(customer);
        redirect.addFlashAttribute("mess", "Thêm mới thành công");
    return "redirect:/customers/";
    }

    @GetMapping("/formEdit")
    public String showEditCustomerForm(@RequestParam Integer id, Model model) {
        Customer customer = customerService.findCustomerById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setIdGuestType(customer.getCustomerType().getIdGuestType());
        customerDto.setCustomerType(customerTypeDto);

        model.addAttribute("customerDto", customerDto);
        model.addAttribute("typeList", customerService.findAllTypeCustomer());
        return "/customer/customer_edit";
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute(value = "customerDto") @Valid CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirect, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("typeList", customerService.findAllTypeCustomer());
            return "/customer/customer_edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        CustomerType customerType = new CustomerType();
        customerType.setIdGuestType(customerDto.getCustomerType().getIdGuestType());
        customer.setCustomerType(customerType);

        redirect.addFlashAttribute("mess", "Thay đổi thành công");
        customerService.save(customer);
        return "redirect:/customers/";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "/customer/detail";
    }
    @PostMapping("/delete")
    public String delete(int id, RedirectAttributes redirect) {
        customerService.delete(id);
        redirect.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/customers/";
    }
}
