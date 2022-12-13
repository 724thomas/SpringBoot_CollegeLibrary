package com.example.springboot_collegelibrary.controller.admin;

import com.example.springboot_collegelibrary.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminBookController {

    @Autowired
    AdminService adminService;

    @GetMapping("/admin/adminBookDetail")
    public String adminBookDetail(@RequestParam String bookId, Model model){
        model.addAttribute("BookDetailEntity" , adminService.getBookDetailByBookId(bookId));
        model.addAttribute("BorrowingBookList" , adminService.getBorrowingBookByBookId(bookId));
        model.addAttribute("BorrowedBookList" , adminService.getBorrowedBookByBookId(bookId));
        model.addAttribute("LatefeeList" , adminService.getLatefeesByBookId(bookId));
        return "adminBookDetail";
    }

    @PostMapping("/admin/adminBookDetail/decrease")
    public String decreaseBookQuantityBy1(@RequestParam String bookId){
        return "redirect:/admin/adminBookDetail?bookId=" + bookId;
    }

    @PostMapping("/admin/adminBookDetail/increase")
    public String increaseBookQuantityBy1(@RequestParam String bookId){
        return "redirect:/admin/adminBookDetail?bookId=" + bookId;
    }
}
