package com.example.demo_borrow_books.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "borrows")
public class BorrowTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 5)
    private String transferId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private boolean returned;
}
