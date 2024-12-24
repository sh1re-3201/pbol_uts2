package com.sh1re.goldenbay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Integer publicationYear;

    private Boolean availability;

    public Book() {
    }

    public Book(String title, String author, Integer publicationYear, Boolean availability) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.availability = availability;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public Integer getPublicationYear() {
        return this.publicationYear;
    }

    public Boolean getAvailability() {
        return this.availability;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public String toString() {
        return "Book(id=" + this.getId() + ", title=" + this.getTitle() + ", author=" + this.getAuthor() + ", publicationYear=" + this.getPublicationYear() + ", availability=" + this.getAvailability() + ")";
    }
}