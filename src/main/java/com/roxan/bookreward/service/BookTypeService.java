package com.roxan.bookreward.service;

import com.roxan.bookreward.model.Book;
import com.roxan.bookreward.model.BookType;
import com.roxan.bookreward.repository.BookTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IBookTypeService")
public class BookTypeService {

    private BookTypeRepository bookTypeRepository;

    public List<BookType> findAll(){
        return bookTypeRepository.findAll();
    }

    public void save(BookType bookType){
        bookTypeRepository.save(bookType);
    }

    public List<Book> findBooksByType(Integer id){
        //TODO: try catch/check if present
        return bookTypeRepository.findById(id).get().getBooks();
    }

    public void deleteCategoryById(Integer id) {
        bookTypeRepository.deleteById(id);
    }
}
