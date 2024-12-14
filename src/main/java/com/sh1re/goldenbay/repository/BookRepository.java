package com.sh1re.goldenbay.repository;

import com.sh1re.goldenbay.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
