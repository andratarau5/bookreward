package com.roxan.bookreward.controller;

import com.roxan.bookreward.model.BookType;
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
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;

    @GetMapping("/showallbooktypes")
    public String showAllBookTypes(Model model){
        List<BookType> bookTypes = bookTypeService.findAll();
        model.addAttribute("booktypes",bookTypes);
        return "booktype/showallbooktypes";
    }

    @GetMapping("/addbooktype")
    public String addBookType(Model model){
        model.addAttribute("booktypes",new BookType());
        return "booktype/addbooktype";
    }

    @PostMapping("/addbooktype")
    public String addBookType(@ModelAttribute BookType bookType){
        bookTypeService.save(bookType);
        return "redirect:/allbooktypes";
    }

    @GetMapping("/type/{id}/books")
    public String viewBooksInGroup(Model model, @PathVariable Integer id){
        model.addAttribute("books",bookTypeService.findBooksByType(id));
        return "booktype/viewbooks";
    }
}
