package com.roxan.bookreward.controller;

import com.roxan.bookreward.model.SHBook;
import com.roxan.bookreward.service.SHBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class SHBookController {

    @Autowired
    private SHBookService shBookService;


    @GetMapping("allshbooks")
    public String showAllSHBooks(Model model){
        List<SHBook> shbookList = shBookService.findAll();
        model.addAttribute("shbooks",shbookList);
        return "shbook/showallshbooks";
    }

    @GetMapping("/addshbook")
    public String addSHBook(Model model){
        model.addAttribute("shbook",new SHBook());
        return "shbook/addshbook";
    }

    @PostMapping("/addshbook")
    public String addSHBook(@ModelAttribute SHBook shBook){
        shBookService.save(shBook);
        return "redirect:/allshbooks";
    }

    @GetMapping("/editshbook/{id}")
    public String editSHBook(Model model, @PathVariable Integer id){
        SHBook shBook = shBookService.findById(id);
        model.addAttribute("shbook",shBook);
        return "shbook/editshbook";
    }

    @PostMapping("/editshbook/{id}")
    public String editSHBook(@ModelAttribute SHBook shBook, @PathVariable Integer id){
        System.out.println(shBook);
        shBookService.save(shBook);
        return "redirect:/allshbooks";
    }

    @GetMapping("/deleteshbook/{id}")
    public String deleteSHBook(@PathVariable Integer id){
        shBookService.deleteById(id);
        return "redirect:/allshbooks";
    }

    @GetMapping("/rentthebook/{id}")
    public String rentTheBook(@ModelAttribute SHBook shBook, @PathVariable Integer id){
        shBookService.findById(id);
        return "shbook/rentthebook";
    }
}
