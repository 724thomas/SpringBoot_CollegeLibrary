package com.example.springboot_collegelibrary.Service;

import com.example.springboot_collegelibrary.Repository.BookBorrowRepository;
import com.example.springboot_collegelibrary.dto.BorrowedBookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BookBorrowService {

    @Autowired
    BookBorrowRepository bookBorrowRepository;

    public int userBorrowABook(String studentEmail, String bookId){
        BorrowedBookDTO borrowedBookDTO = new BorrowedBookDTO();
        borrowedBookDTO.setBorrowStudentEmail(studentEmail);
        borrowedBookDTO.setBorrowBookId(bookId);
        bookBorrowRepository.decreaseAvailableBookByBookId(bookId);
        System.out.println("BookBorrowService.userBorrowABook : Successfully Borrowed The Book");
        return bookBorrowRepository.userBorrowsBook(borrowedBookDTO);

    }

    public boolean userAlreadyBorrowedBook(String studentEmail, String bookId){
        HashMap<String,String> emailAndBookId = new HashMap<>();
        emailAndBookId.put("studentEmail",studentEmail);
        emailAndBookId.put("bookId",bookId);
        return bookBorrowRepository.userAlreadyBorrowedBook(emailAndBookId);
    }
}
