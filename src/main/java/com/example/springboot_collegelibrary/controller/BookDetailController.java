package com.example.springboot_collegelibrary.controller;

import com.example.springboot_collegelibrary.Service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookDetailController {

    @Autowired
    BookDetailService bookDetailService;

    @GetMapping("/book")
    public String book(String bookId, Model model){
        model.addAttribute("BookDetailDTO", bookDetailService.selectBookDetailByBookId(bookId));
        return "bookdetail";
    }
}
