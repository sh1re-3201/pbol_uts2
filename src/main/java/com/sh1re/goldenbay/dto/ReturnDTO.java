package com.sh1re.goldenbay.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReturnDTO {
    private Long id;
    private Long borrowingId;
    private LocalDate returnDate;
}
