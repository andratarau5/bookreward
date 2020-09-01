package com.roxan.bookreward.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
