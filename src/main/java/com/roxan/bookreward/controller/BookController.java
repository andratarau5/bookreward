package com.roxan.bookreward.controller;

import com.roxan.bookreward.model.Book;
import com.roxan.bookreward.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/showallbooks")
    public String showAllBooks(Model model){
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("books",bookList);
        return "showallbooks";
    }


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/addbook")              // we need GetMapping so we can populate our template
    public String addBook(Model model){
        model.addAttribute("book",new Book());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/showallbooks";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(Model model, @PathVariable Integer id){
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book",new Book());
        return "editbook";
    }

    @PostMapping("/editbook/{id}")
    public String editBook(@ModelAttribute Book book, @PathVariable Integer id){
        Book database_book = bookRepository.findById(id).get(); //get it from the database to be able to update the id
        database_book.setTitle(book.getTitle());    //update fields
        database_book.setAuthor(book.getAuthor());
        database_book.setYear(book.getYear());
        System.out.println(database_book);
        bookRepository.save(book);
        return "redirect:/showallbooks";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookRepository.deleteById(id);
        return "redirect:/showallbooks";
    }
}
