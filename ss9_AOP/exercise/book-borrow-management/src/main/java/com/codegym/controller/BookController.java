package com.codegym.controller;

import com.codegym.Service.IBookService;
import com.codegym.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("bookList",this.bookService.findAll());
        return "book_list";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("bookList", bookService.findById(id));
        return "/book_detail";
    }
    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Integer id, Model model) {
        Book book = bookService.findById(id);
        if (book.getQuantityBook()==0){
            model.addAttribute("messages","sách đã được mượn hết");
            return "redirect:/";
        }
        book.setQuantityBook(book.getQuantityBook() - 1 );
        book.setQuantityBorrow(book.getQuantityBorrow() + 1 );
        bookService.save(book);
        model.addAttribute("messages","mượn sách thành công");
        model.addAttribute("detail", bookService.findById(id));
        return "redirect:/";
    }

    @PostMapping("/giveBack")
    public String giveBack(@RequestParam Integer id, Model model) {
        Book book = bookService.findById(id);
        if (book.getQuantityBorrow()==0){
            model.addAttribute("messages","Sách đã đủ");
            return "redirect:/";
        }
        book.setQuantityBook(book.getQuantityBook() + 1);
        book.setQuantityBorrow(book.getQuantityBorrow() - 1 );
        bookService.save(book);
        model.addAttribute("messages","Trả sách thành công");
        model.addAttribute("detail", bookService.findById(id));
        return "redirect:/";
    }
}
