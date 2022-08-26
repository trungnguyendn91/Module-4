package com.codegym.Service;

import com.codegym.model.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookService {
    List <Book> findAll();

    void save (Book book);

    Book findById(Integer id);
}
