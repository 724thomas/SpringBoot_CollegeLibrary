package com.example.springboot_collegelibrary.Service;

import com.example.springboot_collegelibrary.Repository.AdminRepository;
import com.example.springboot_collegelibrary.entity.BookTableEntity;
import com.example.springboot_collegelibrary.entity.BorrowedBookTableEntity;
import com.example.springboot_collegelibrary.entity.LateFeesTableEntity;
import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    // Student Management---------------------------------------------------------------------------------------------
    public ArrayList<StudentTableEntity> getAllStudents(){
        return adminRepository.getAllStudents();
    }
    public ArrayList<StudentTableEntity> searchStudentByKeyword(String keyword){
        return adminRepository.searchStudentByKeyword(keyword);
    }
    public int deleteStudentByStudentEmail(String studentEmail){
        return adminRepository.deleteStudentByStudentEmail(studentEmail);
    }

    // Book Management---------------------------------------------------------------------------------------------
    public ArrayList<BookTableEntity> searchBookByKeyword(String keyword){
        return adminRepository.searchBookDetailByKeyword(keyword);
    }
    public BookTableEntity getBookDetailByBookId(String bookId){
        return adminRepository.getBookDetailByBookId(bookId);
    }
    public ArrayList<BorrowedBookTableEntity> getBorrowingBookByBookId(String bookId){
        return adminRepository.getBorrowingBookByBookId(bookId);
    }
    public ArrayList<BorrowedBookTableEntity> getBorrowedBookByBookId(String bookId){
        return adminRepository.getBorrowedBookByBookId(bookId);
    }
    public ArrayList<LateFeesTableEntity> getLatefeesByBookId(String bookId){
        return adminRepository.getLatefeesByBookId(bookId);
    }
}
