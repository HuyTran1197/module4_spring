package com.example.demo_borrow_books.controller;

import com.example.demo_borrow_books.exception.BookOutOfStockException;
import com.example.demo_borrow_books.exception.InvalidTransferIdException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(BookOutOfStockException.class)
    public String handleOutOfStock(Model model) {
        model.addAttribute("error", "Sách đã hết");
        return "error";
    }

    @ExceptionHandler(InvalidTransferIdException.class)
    public String handleInvalidTransfer(Model model) {
        model.addAttribute("error", "Mã mượn không hợp lệ");
        return "error";
    }

}
