package com.example.demo_borrow_books.repository;

import com.example.demo_borrow_books.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findByNameContaining(String searchName, Pageable pageable);
}
