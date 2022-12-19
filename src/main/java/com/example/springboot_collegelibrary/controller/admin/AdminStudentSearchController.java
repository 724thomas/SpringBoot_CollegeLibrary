package com.example.springboot_collegelibrary.controller.admin;


import com.example.springboot_collegelibrary.service.AdminService;
import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdminStudentSearchController {

    @Autowired
    AdminService adminService;

    @GetMapping("/admin/studentSearch")
    public ArrayList<StudentTableEntity> studentSearch(@RequestParam String keyword){
        try{
            return adminService.searchStudentByKeyword(keyword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
