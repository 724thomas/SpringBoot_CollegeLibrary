package com.example.springboot_collegelibrary.Repository;


import com.example.springboot_collegelibrary.entity.BookTableEntity;
import com.example.springboot_collegelibrary.entity.BorrowedBookTableEntity;
import com.example.springboot_collegelibrary.entity.LateFeesTableEntity;
import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import com.example.springboot_collegelibrary.mapper.AdminCommandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AdminRepository {

    @Autowired
    AdminCommandMapper adminCommandMapper;
// Student Management---------------------------------------------------------------------------------------------
    public ArrayList<StudentTableEntity> getAllStudents(){
        return adminCommandMapper.getAllStudents();
    }
    public ArrayList<StudentTableEntity> searchStudentByKeyword(String keyword){
        return adminCommandMapper.searchStudentByKeyword(keyword);
    }
    public int deleteStudentByStudentEmail(String studentEmail){
        return adminCommandMapper.deleteStudentByStudentEmail(studentEmail);
    }
    public StudentTableEntity selectStudentByEmail(String studentEmail0){
        return adminCommandMapper.selectStudentByEmail(studentEmail0);
    }


// Book Management---------------------------------------------------------------------------------------------
    public ArrayList<BookTableEntity> searchBookDetailByKeyword(String keyword){
        return adminCommandMapper.searchBookDetailByKeyword(keyword);
    }
    public BookTableEntity getBookDetailByBookId(String bookId){
        return adminCommandMapper.getBookDetailByBookId(bookId);
    }
    public ArrayList<BorrowedBookTableEntity> getBorrowingBookByBookId(String bookId){
        return adminCommandMapper.getBorrowingBookByBookId(bookId);
    }
public ArrayList<BorrowedBookTableEntity> getBorrowedBookByBookId(String bookId){
        return adminCommandMapper.getBorrowedBookByBookId(bookId);
    }
    public ArrayList<LateFeesTableEntity> getLatefeesByBookId(String bookId){
        return adminCommandMapper.getLatefeesByBookId(bookId);
    }
    public int increaseTotalQuantityOfBook(String bookId){
        return adminCommandMapper.increaseTotalQuantityOfBook(bookId);
    }
    public int decreaseTotalQuantityOfBook(String bookId){
        return adminCommandMapper.decreaseTotalQuantityOfBook(bookId);
    }
}
