package com.sh1re.goldenbay.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BorrowingDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
}
