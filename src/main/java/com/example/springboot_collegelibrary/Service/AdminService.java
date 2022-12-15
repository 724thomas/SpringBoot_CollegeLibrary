package com.example.springboot_collegelibrary.Service;

import com.example.springboot_collegelibrary.Repository.AdminRepository;
import com.example.springboot_collegelibrary.dto.AdminBookBorrowDTO;
import com.example.springboot_collegelibrary.dto.AdminBookBorrowedDTO;
import com.example.springboot_collegelibrary.entity.BookTableEntity;
import com.example.springboot_collegelibrary.entity.BorrowedBookTableEntity;
import com.example.springboot_collegelibrary.entity.LateFeesTableEntity;
import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

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

    public StudentTableEntity selectStudentByEmail(String studentEmail0){
        return adminRepository.selectStudentByEmail(studentEmail0);
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
    public int increaseTotalQuantityOfBook(String bookId){
        return adminRepository.increaseTotalQuantityOfBook(bookId);
    }
    public int decreaseTotalQuantityOfBook(String bookId){
        return adminRepository.decreaseTotalQuantityOfBook(bookId);
    }
    public int insertNewBook(HashMap<String, String> newBookInfo){
        String bookId = newBookInfo.get("bookId");
        String bookTitle = newBookInfo.get("bookTitle");
        String bookAuthor = newBookInfo.get("bookAuthor");
        int bookQuantity =Integer.parseInt( newBookInfo.get("bookQuantity") );
        int bookAvailable =Integer.parseInt( newBookInfo.get("bookQuantity") );
        int bookPrice =Integer.parseInt( newBookInfo.get("bookPrice") );
        BookTableEntity bookTableEntity = new BookTableEntity(bookId, bookTitle, bookAuthor, bookQuantity, bookAvailable, bookPrice);
        if (getBookDetailByBookId(newBookInfo.get("bookId")) != null){
            return 0;
        }else{
            adminRepository.insertNewBook(bookTableEntity);
            return 1;
        }
    }
    public ArrayList<AdminBookBorrowDTO> getAdminBookOverdueList(){
        return adminRepository.getAdminBookOverdueList();
    }
    public ArrayList<AdminBookBorrowDTO> getAdminBookBorrowList(){
        return adminRepository.getAdminBookBorrowList();
    }
    public ArrayList<AdminBookBorrowedDTO> getAdminBookBorrowedList(){
        return adminRepository.getAdminBookBorrowedList();
    }
}
