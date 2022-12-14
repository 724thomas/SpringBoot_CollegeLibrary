package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.entity.BookTableEntity;
import com.example.springboot_collegelibrary.entity.BorrowedBookTableEntity;
import com.example.springboot_collegelibrary.entity.LateFeesTableEntity;
import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AdminCommandMapper {
//    Student Management---------------------------------------------------------------------------------------------
    public ArrayList<StudentTableEntity> getAllStudents();
    public ArrayList<StudentTableEntity> searchStudentByKeyword(String keyword);
    public int deleteStudentByStudentEmail(String studentEmail);
    public StudentTableEntity selectStudentByEmail(String studentEmail0);

//    Book Management---------------------------------------------------------------------------------------------
    public ArrayList<BookTableEntity> searchBookDetailByKeyword(String keyword);
    public BookTableEntity getBookDetailByBookId(String bookId);
    public ArrayList<BorrowedBookTableEntity> getBorrowingBookByBookId(String bookId);
    public ArrayList<BorrowedBookTableEntity> getBorrowedBookByBookId(String bookId);
    public ArrayList<LateFeesTableEntity> getLatefeesByBookId(String bookId);
    public int increaseTotalQuantityOfBook(String bookId);
    public int decreaseTotalQuantityOfBook(String bookId);
}
