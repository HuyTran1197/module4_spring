package com.example.demo_borrow_books.service;

public interface IBorrowService {
    String borrowBook(int bookId);
    void returned(String transferId);
}
