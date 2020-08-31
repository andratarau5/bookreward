package com.roxan.bookreward.controller;

import com.roxan.bookreward.model.Book;
import com.roxan.bookreward.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/allbooks")
    public String showAllBooks(Model model){
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("books",bookList);
        return "showallbooks";
    }

//    @PostMapping("/allbooks")
//    public String showAllBooks(@ModelAttribute Book book){
//        bookRepository.findAll();
//        return "redirect:/allbooks";
//    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/addbook")
    public String addBook(Model model){
        model.addAttribute("book",new Book());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/allbooks";
    }
}
