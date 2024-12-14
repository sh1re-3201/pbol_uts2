package com.sh1re.goldenbay.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "borrowing_id", nullable = false)
    private Borrowing borrowing;

    private LocalDateTime returnDate;
}