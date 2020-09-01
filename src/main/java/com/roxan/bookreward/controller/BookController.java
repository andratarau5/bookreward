package com.roxan.bookreward.controller;

import com.roxan.bookreward.model.Book;
import com.roxan.bookreward.service.BookService;
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
    private BookService bookService;

    @GetMapping("/showallbooks")
    public String showAllBooks(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books",bookList);
        return "book/showallbooks";
    }


    @GetMapping("/addbook")              // we need GetMapping so we can populate our template
    public String addBook(Model model){
        model.addAttribute("book",new Book());
        return "book/addbook";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/showallbooks";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(Model model, @PathVariable Integer id){
        Book book = bookService.findById(id);
        model.addAttribute("book",new Book());
        return "book/editbook";
    }

    @PostMapping("/editbook/{id}")
    public String editBook(@ModelAttribute Book book, @PathVariable Integer id){
        Book database_book = bookService.findById(id); //get it from the database to be able to update the id
        database_book.setTitle(book.getTitle());    //update fields
        database_book.setAuthor(book.getAuthor());
        database_book.setYear(book.getYear());
        System.out.println(database_book);
        bookService.save(book);
        return "redirect:/showallbooks";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookService.deleteById(id);
        return "redirect:/showallbooks";
    }
}
