package com.example.springboot_collegelibrary.controller;

import com.example.springboot_collegelibrary.Service.BookBorrowService;
import com.example.springboot_collegelibrary.Service.BookDetailService;
import com.example.springboot_collegelibrary.dto.BookDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class BookDetailController {

    @Autowired
    BookDetailService bookDetailService;
    @Autowired
    BookBorrowService bookBorrowService;

    @GetMapping("/book")
    public String book(String bookId, Model model, HttpSession session){
        model.addAttribute("BookDetailDTO", bookDetailService.selectBookDetailByBookId(bookId));
        boolean AlreadyBorrowed = bookBorrowService.userAlreadyBorrowedBook((String) session.getAttribute("email"),bookId);
        if (AlreadyBorrowed){
            model.addAttribute("borrowedAlready", 1);
        }else{
            model.addAttribute("borrowedAlready", 0);
        }
        return "bookdetail";
    }
}
