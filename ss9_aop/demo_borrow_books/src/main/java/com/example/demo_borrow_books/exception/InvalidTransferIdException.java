package com.example.demo_borrow_books.exception;

public class InvalidTransferIdException extends RuntimeException{

    public InvalidTransferIdException(String mess){
        super(mess);
    }
}
