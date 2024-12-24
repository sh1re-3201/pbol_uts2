package com.sh1re.goldenbay.service;

import com.sh1re.goldenbay.dto.BookDTO;
import com.sh1re.goldenbay.model.Book;
import com.sh1re.goldenbay.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Create a new book
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        book = bookRepository.save(book);
        return convertToDTO(book);
    }

    // Get all books
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get book by ID
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return convertToDTO(book);
    }

    // Update book
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setPublicationYear(bookDTO.getPublicationYear());
        existingBook.setAvailability(bookDTO.getAvailability());
        Book updatedBook = bookRepository.save(existingBook);
        return convertToDTO(updatedBook);
    }

    // Delete book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @PostConstruct
    public void init() {
        try {
            System.out.println("Initializing books...");
                bookRepository.save(new Book("Bible", "Various Artists", 100, true));

                bookRepository.save(new Book("Spider-Man", "Stan Lee", 1982, false));


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error during UserService initialization", e);
        }
    }

    // Convert DTO to Entity
    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setAvailability(bookDTO.getAvailability());
        return book;
    }

    // Convert Entity to DTO
    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setAvailability(book.getAvailability());
        return bookDTO;
    }
}
