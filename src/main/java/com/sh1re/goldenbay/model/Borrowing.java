package com.sh1re.goldenbay.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private LocalDateTime borrowDate;

    private LocalDateTime returnDate; // Optional, null if not yet returned

    public Borrowing() {
    }

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public Book getBook() {
        return this.book;
    }

    public LocalDateTime getBorrowDate() {
        return this.borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return this.returnDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public String toString() {
        return "Borrowing(id=" + this.getId() + ", user=" + this.getUser() + ", book=" + this.getBook() + ", borrowDate=" + this.getBorrowDate() + ", returnDate=" + this.getReturnDate() + ")";
    }
}
