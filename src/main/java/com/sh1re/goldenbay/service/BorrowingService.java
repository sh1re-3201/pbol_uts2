package com.sh1re.goldenbay.service;

import com.sh1re.goldenbay.dto.BorrowingDTO;
import com.sh1re.goldenbay.model.Borrowing;
import com.sh1re.goldenbay.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    // Create a new borrowing record
    public BorrowingDTO createBorrowing(BorrowingDTO borrowingDTO) {
        Borrowing borrowing = convertToEntity(borrowingDTO);
        borrowing = borrowingRepository.save(borrowing);
        return convertToDTO(borrowing);
    }

    // Get all borrowings
    public List<BorrowingDTO> getAllBorrowings() {
        return borrowingRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get borrowing by ID
    public BorrowingDTO getBorrowingById(Long id) {
        Borrowing borrowing = borrowingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));
        return convertToDTO(borrowing);
    }

    // Convert DTO to Entity
    private Borrowing convertToEntity(BorrowingDTO borrowingDTO) {
        Borrowing borrowing = new Borrowing();
        borrowing.setBorrowDate(borrowingDTO.getBorrowDate());
        borrowing.setReturnDate(borrowingDTO.getReturnDate());
        // Proper user and book lookup logic will go here
        return borrowing;
    }

    // Convert Entity to DTO
    private BorrowingDTO convertToDTO(Borrowing borrowing) {
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        borrowingDTO.setId(borrowing.getId());
        borrowingDTO.setBorrowDate(borrowing.getBorrowDate());
        borrowingDTO.setReturnDate(borrowing.getReturnDate());
        borrowingDTO.setUserId(borrowing.getUser().getId());
        borrowingDTO.setBookId(borrowing.getBook().getId());
        return borrowingDTO;
    }
}
