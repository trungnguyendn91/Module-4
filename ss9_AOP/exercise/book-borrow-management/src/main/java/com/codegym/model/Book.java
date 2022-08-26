package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "book_name")
    private String bookName;

    @Column (name = "book_title", columnDefinition = "text")
    private String bookTittle;

    @Column(name = "quantity_book")
    private int quantityBook;
    @Column (name = "quantity_borrow")
    private int quantityBorrow;

    public Book() {
    }

    public Book(Integer id, String bookName, String bookTittle, int quantityBook, int quantityBorrow) {
        this.id = id;
        this.bookName = bookName;
        this.bookTittle = bookTittle;
        this.quantityBook = quantityBook;
        this.quantityBorrow = quantityBorrow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookTittle() {
        return bookTittle;
    }

    public void setBookTittle(String bookTittle) {
        this.bookTittle = bookTittle;
    }

    public int getQuantityBook() {
        return quantityBook;
    }

    public void setQuantityBook(int quantityBook) {
        this.quantityBook = quantityBook;
    }

    public int getQuantityBorrow() {
        return quantityBorrow;
    }

    public void setQuantityBorrow(int quantityBorrow) {
        this.quantityBorrow = quantityBorrow;
    }
}
