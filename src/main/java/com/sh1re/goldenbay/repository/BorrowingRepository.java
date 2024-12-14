package com.sh1re.goldenbay.repository;

import com.sh1re.goldenbay.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    List<Borrowing> findByUserId(Long userId);
}
