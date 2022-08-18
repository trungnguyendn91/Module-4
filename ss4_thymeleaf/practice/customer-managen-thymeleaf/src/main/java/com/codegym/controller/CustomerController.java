package com.codegym.controller;

import com.codegym.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.codegym.service.ICustomer;
import com.codegym.service.impl.CustomerService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
    @RequestMapping ("/customer")
public class CustomerController {
    @Autowired
    private ICustomer customerService = new CustomerService();

    @GetMapping
    public String index(Model model){

        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

//    Phương thức thêm mới
    @GetMapping ("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    // ta sẽ tạo phương thức save() để lưu một customer, như sau:
    @PostMapping("/save")
    public String save(Customer customer){
        customer.setId((int) (Math.random() * 1000));
        customerService.save(customer);
        return "redirect:/customer";
    }
// ta viết thêm phương thức edit để hiển thị trang edit.html:
    //Tham số @PathVariable int id lấy id của customer từ đường dẫn rồi gán vào biến id.
//hàm customerService.findById(id) sẽ lấy customer theo id rồi truyền sang view edit.html
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }
    //ta sẽ tạo phương thức update() để lưu một sửa đổi, như sau:
    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }
    // phương thức  GET delete() để hiển thị trang delete.html:
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }
    //tạo phương thức POST delete() để xóa khách hàng, như sau:
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }
    //phương thức  GET view() để hiển thị trang view.html:
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
