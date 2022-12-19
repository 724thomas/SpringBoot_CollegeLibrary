package com.example.springboot_collegelibrary.controller.admin;

import com.example.springboot_collegelibrary.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

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
        adminService.decreaseTotalQuantityOfBook(bookId);
        return "redirect:/admin/adminBookDetail?bookId=" + bookId;
    }

    @PostMapping("/admin/adminBookDetail/increase")
    public String increaseBookQuantityBy1(@RequestParam String bookId){
        adminService.increaseTotalQuantityOfBook(bookId);
        return "redirect:/admin/adminBookDetail?bookId=" + bookId;
    }

    @PostMapping("/admin/bookManagement/bookAdd")
    public String addBook(@RequestParam HashMap<String,String> newBookInfo, Model model){
        if (adminService.insertNewBook(newBookInfo)==1){
            System.out.println("Insert new book successfully");
            return "redirect:/admin/adminBookDetail?bookId=" + newBookInfo.get("bookId");
        }else{
            System.out.println("Already Exists");
            model.addAttribute("BookAlreadyExists", "이미 등록되어 있는 책입니다.");
            return "adminBookAdd";
        }

    }

    @GetMapping("/admin/bookManagement/bookAdd")
    public String addBook(){
        return "adminBookAdd";
    }
}
