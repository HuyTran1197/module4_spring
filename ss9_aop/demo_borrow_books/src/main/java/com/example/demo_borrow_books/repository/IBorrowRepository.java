package com.example.demo_borrow_books.repository;

import com.example.demo_borrow_books.entity.BorrowTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<BorrowTransfer,Integer> {
    BorrowTransfer findByTransferId(String transferId);
}
