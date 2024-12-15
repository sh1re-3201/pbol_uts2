package com.sh1re.goldenbay.controller;

import com.sh1re.goldenbay.dto.ReturnDTO;
import com.sh1re.goldenbay.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/returns")
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    // Create a new return record
    @PostMapping
    public ResponseEntity<ReturnDTO> createReturn(@RequestBody ReturnDTO returnDTO) {
        ReturnDTO createdReturn = returnService.createReturn(returnDTO);
        return ResponseEntity.ok(createdReturn);
    }

    // Get all returns
    @GetMapping
    public ResponseEntity<List<ReturnDTO>> getAllReturns() {
        List<ReturnDTO> returns = returnService.getAllReturns();
        return ResponseEntity.ok(returns);
    }

    // Get return by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReturnDTO> getReturnById(@PathVariable Long id) {
        ReturnDTO returnEntity = returnService.getReturnById(id);
        return ResponseEntity.ok(returnEntity);
    }
}
