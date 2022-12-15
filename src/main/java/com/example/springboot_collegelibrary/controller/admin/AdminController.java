package com.example.springboot_collegelibrary.controller.admin;


import com.example.springboot_collegelibrary.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/adminMenu")
    public String admin(){
        return "adminMenu";
    }

    @GetMapping("/studentManagement")
    public String studentManagement(){
        return "adminStudentSearch";
    }

    @GetMapping("/bookManagement")
    public String bookManagement(){
        return "adminBookSearch";
    }

    @GetMapping("/bookHistoryManagement")
    public String borrowManagement(Model model){
        model.addAttribute("overdueBookList", adminService.getAdminBookOverdueList());
        model.addAttribute("borrowBookList", adminService.getAdminBookBorrowList());
        model.addAttribute("borrowedBookList", adminService.getAdminBookBorrowedList());
        return "adminBookHistoryManagement";
    }

    @GetMapping("/overdueManagement")
    public String overdueManagement(){
        return "overdueManagement";
    }


    //기능
    //1. 도서관리
    // - 도서등록
    // - 도서수정
    // - 도서삭제

    //2. 회원관리
    // - 회원등록
    // - 회원수정
    // - 회원삭제

    //3. 대여관리
    // - 대여등록
    // - 대여수정
    // - 대여삭제

    //4. 반납관리
    // - 반납등록
    // - 반납수정
    // - 반납삭제

    //5. 연체관리
    // - 연체등록
    // - 연체수정
    // - 연체삭제

    //6. 통계관리
    // - 통계등록
    // - 통계수정
    // - 통계삭제

    //7. 로그아웃



}
