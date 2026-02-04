package com.example.demo_borrow_books.service;

import com.example.demo_borrow_books.entity.Book;
import com.example.demo_borrow_books.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;


    @Override
    public Page<Book> findByNameContaining(String searchName, Pageable pageable) {
        return bookRepository.findByNameContaining(searchName, pageable);
    }

    @Override
    public boolean save(Book book) {
        try {
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
