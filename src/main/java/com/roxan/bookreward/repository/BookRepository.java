package com.roxan.bookreward.repository;

import com.roxan.bookreward.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
