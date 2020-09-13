package com.roxan.bookreward.service;


import com.roxan.bookreward.model.Book;
import com.roxan.bookreward.model.BookType;
import com.roxan.bookreward.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("IBookService")
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
