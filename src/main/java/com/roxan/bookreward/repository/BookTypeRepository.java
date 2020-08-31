package com.roxan.bookreward.repository;

import com.roxan.bookreward.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypeRepository extends JpaRepository<BookType,Integer> {
}
