package com.sh1re.goldenbay.controller;

import com.sh1re.goldenbay.dto.BorrowingDTO;
import com.sh1re.goldenbay.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    // Create a new borrowing record
    @PostMapping
    public ResponseEntity<BorrowingDTO> createBorrowing(@RequestBody BorrowingDTO borrowingDTO) {
        BorrowingDTO createdBorrowing = borrowingService.createBorrowing(borrowingDTO);
        return ResponseEntity.ok(createdBorrowing);
    }

    // Get all borrowings
    @GetMapping
    public ResponseEntity<List<BorrowingDTO>> getAllBorrowings() {
        List<BorrowingDTO> borrowings = borrowingService.getAllBorrowings();
        return ResponseEntity.ok(borrowings);
    }

    // Get borrowing by ID
    @GetMapping("/{id}")
    public ResponseEntity<BorrowingDTO> getBorrowingById(@PathVariable Long id) {
        BorrowingDTO borrowing = borrowingService.getBorrowingById(id);
        return ResponseEntity.ok(borrowing);
    }
}
