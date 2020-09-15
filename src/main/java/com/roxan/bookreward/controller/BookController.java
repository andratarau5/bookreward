package com.roxan.bookreward.controller;

import com.roxan.bookreward.model.Book;
import com.roxan.bookreward.service.BookService;
import com.roxan.bookreward.service.BookTypeService;
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
    private BookTypeService bookTypeService;

    @Autowired
    private BookService bookService;

    @GetMapping("allbooks")
    public String showAllBooks(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books",bookList);
        return "book/showallbooks";
    }

    @GetMapping("/addbook")              // we need GetMapping so we can populate our template
    public String addBook(Model model){
        model.addAttribute("booktypes",bookTypeService.findAll());
        model.addAttribute("book",new Book());
        return "book/addbook";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/allbooks";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(Model model, @PathVariable Integer id){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        model.addAttribute("booktypes", bookTypeService.findAll());
        return "book/editbook";
    }

    @PostMapping("/editbook/{id}")
    public String editBook(@ModelAttribute Book book, @PathVariable Integer id){
        System.out.println(book);
        bookService.save(book);
        return "redirect:/allbooks";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookService.deleteById(id);
        return "redirect:/allbooks";
    }

    public void saveFavorite(Model model, List<Book> books) {



    }
}
