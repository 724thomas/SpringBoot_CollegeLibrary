package com.example.springboot_collegelibrary.controller.admin;

import com.example.springboot_collegelibrary.Service.AdminService;
import com.example.springboot_collegelibrary.Service.MoneyTransactionService;
import com.example.springboot_collegelibrary.Service.StudentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminStudentController {

    @Autowired
    AdminService adminService;
    @Autowired
    StudentHistoryService studentHistoryService;
    @Autowired
    MoneyTransactionService moneyTransactionService;

    @GetMapping("/studentDelete")
    public String studentDelete(@RequestParam String studentEmail){
        // ** 학생을 삭제하게 되면, 학생이 대여한 책들도 모두 삭제되고, 학생의 포인트도 삭제되므로 문제가 생긴다. 일단 html단에서 버튼을 제외했다. **
        return "redirect:/admin/studentManagement";
    }

    @GetMapping("/studentDetail")
    public String studentDetail(@RequestParam String studentEmail, Model model){
        model.addAttribute("studentCurrentBorrowDTO",studentHistoryService.getStudentCurrentBorrowList(studentEmail));
        model.addAttribute("studentHistoryDTO",studentHistoryService.getStudentBorrowedBookHistory(studentEmail));
        model.addAttribute("totalTransactionDTOList", moneyTransactionService.selectStudentTotalTransactionByEmail(studentEmail));
        return "adminStudentDetail";
    }
}
