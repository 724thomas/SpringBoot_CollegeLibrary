package com.example.springboot_collegelibrary.controller.admin;

import com.example.springboot_collegelibrary.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminStudent {

    @Autowired
    private AdminService adminService;

    @GetMapping("/studentDelete")
    public String studentDelete(@RequestParam String studentEmail){
        System.out.println("AdminStudent.studentDelete : Student(" + studentEmail + ") Deleted");
        return "redirect:/admin/studentManagement";
    }
}
