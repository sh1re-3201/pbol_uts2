package com.sh1re.goldenbay.service;

import com.sh1re.goldenbay.dto.ReturnDTO;
import com.sh1re.goldenbay.model.Borrowing;
import com.sh1re.goldenbay.model.Return;
import com.sh1re.goldenbay.repository.BorrowingRepository;
import com.sh1re.goldenbay.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReturnService {

    @Autowired
    private ReturnRepository returnRepository;

    @Autowired
    private BorrowingRepository borrowingRepository;

    // Create a new return record
    @Transactional
    public ReturnDTO createReturn(ReturnDTO returnDTO) {
        Return returnEntity = convertToEntity(returnDTO);
        returnEntity = returnRepository.save(returnEntity);
        return convertToDTO(returnEntity);
    }

    // Get all returns
    public List<ReturnDTO> getAllReturns() {
        return returnRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get return by ID
    public ReturnDTO getReturnById(Long id) {
        Return returnEntity = returnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Return not found with ID: " + id));
        return convertToDTO(returnEntity);
    }

    // Delete return by ID
    @Transactional
    public void deleteReturn(Long id) {
        Return returnEntity = returnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Return not found with ID: " + id));
        returnRepository.delete(returnEntity);
    }

    // Convert DTO to Entity
    private Return convertToEntity(ReturnDTO returnDTO) {
        if (returnDTO.getBorrowingId() == null) {
            throw new IllegalArgumentException("Borrowing ID cannot be null");
        }

        Borrowing borrowing = borrowingRepository.findById(returnDTO.getBorrowingId())
                .orElseThrow(() -> new RuntimeException("Borrowing not found with ID: " + returnDTO.getBorrowingId()));
        Return returnEntity = new Return();
        returnEntity.setReturnDate(returnDTO.getReturnDate());
        returnEntity.setBorrowing(borrowing);
        return returnEntity;
    }

    // Convert Entity to DTO
    private ReturnDTO convertToDTO(Return returnEntity) {
        ReturnDTO returnDTO = new ReturnDTO();
        returnDTO.setId(returnEntity.getId());
        returnDTO.setReturnDate(returnEntity.getReturnDate());
        returnDTO.setBorrowingId(returnEntity.getBorrowing().getId());
        return returnDTO;
    }
}
