package com.example.springboot_collegelibrary.controller.student;

import com.example.springboot_collegelibrary.Service.BookBorrowService;
import com.example.springboot_collegelibrary.Service.BookReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class BookBorrowReturnController {

    @Autowired
    BookBorrowService bookBorrowService;
    @Autowired
    BookReturnService bookReturnService;

    @PostMapping("/borrowBook")
    public String borrowBook(@RequestParam String bookId, HttpSession session){
        if (bookBorrowService.userBorrowABook((String) session.getAttribute("email"),bookId)){
            System.out.println("BookBorrowReturnController.borrowBook : Redirecting to Student History Page");
            return "redirect:/studentHistory";
        }else{
            System.out.println("BookBorrowReturnController.borrowBook : Redirecting to Deposit Page");
            return "redirect:/goDeposit";
        }
    }

    @PostMapping("/returnBook")
    public String returnBook(@RequestParam String bookId, HttpSession session, Model model){
        bookReturnService.userReturnABook((String) session.getAttribute("email"),bookId);
        System.out.println("BookBorrowReturnController.returnBook : Redirecting to Student History Page");
        return "redirect:/studentHistory";
    }
}
