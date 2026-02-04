package com.example.demo_borrow_books.service;

import com.example.demo_borrow_books.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findByNameContaining(String searchName, Pageable pageable);
    boolean save(Book book);
    Book findById(int id);
    boolean deleteById(int id);
}
