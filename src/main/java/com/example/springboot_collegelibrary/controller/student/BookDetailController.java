package com.example.springboot_collegelibrary.controller.student;

import com.example.springboot_collegelibrary.service.BookBorrowService;
import com.example.springboot_collegelibrary.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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
