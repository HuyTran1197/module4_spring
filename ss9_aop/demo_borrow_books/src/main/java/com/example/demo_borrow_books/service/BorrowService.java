package com.example.demo_borrow_books.service;

import com.example.demo_borrow_books.entity.Book;
import com.example.demo_borrow_books.entity.BorrowTransfer;
import com.example.demo_borrow_books.exception.BookOutOfStockException;
import com.example.demo_borrow_books.exception.InvalidTransferIdException;
import com.example.demo_borrow_books.repository.IBookRepository;
import com.example.demo_borrow_books.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService implements IBorrowService{
    @Autowired
    private IBorrowRepository borrowRepository;
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public String borrowBook(int bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                ()->new BookOutOfStockException("không tìm thấy sách")
        );

        if (book.getQuantity()==0){
            throw new BookOutOfStockException("Sách đã hết");
        }
        book.setQuantity(book.getQuantity()-1);
        bookRepository.save(book);

        String transferId = String.valueOf((int)(Math.random()*90000)+10000);

        BorrowTransfer borrowTransfer = new BorrowTransfer();
        borrowTransfer.setTransferId(transferId);
        borrowTransfer.setBook(book);
        borrowTransfer.setReturned(false);

        borrowRepository.save(borrowTransfer);
        return transferId;
    }

    @Override
    public void returned(String transferId) {
        BorrowTransfer borrowTransfer = borrowRepository.findByTransferId(transferId);
        if (borrowTransfer==null||borrowTransfer.isReturned()){
            throw new InvalidTransferIdException("Mã mượn không hợp lệ");
        }

        Book book = borrowTransfer.getBook();
        book.setQuantity(book.getQuantity()+1);
        bookRepository.save(book);
        borrowTransfer.setReturned(true);
        borrowRepository.save(borrowTransfer);
    }
}
