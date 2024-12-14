package com.sh1re.goldenbay.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Integer publicationYear;

    private Boolean availability;
}