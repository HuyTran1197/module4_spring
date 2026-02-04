package com.example.demo_borrow_books.exception;

public class BookOutOfStockException extends RuntimeException{

    public BookOutOfStockException(String mess){
        super(mess);
    }
}
