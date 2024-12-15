package com.sh1re.goldenbay.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "borrowing_id", nullable = false)
    private Borrowing borrowing;

    private LocalDateTime returnDate;

    public Return() {
    }

    public Long getId() {
        return this.id;
    }

    public Borrowing getBorrowing() {
        return this.borrowing;
    }

    public LocalDateTime getReturnDate() {
        return this.returnDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBorrowing(Borrowing borrowing) {
        this.borrowing = borrowing;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public String toString() {
        return "Return(id=" + this.getId() + ", borrowing=" + this.getBorrowing() + ", returnDate=" + this.getReturnDate() + ")";
    }
}