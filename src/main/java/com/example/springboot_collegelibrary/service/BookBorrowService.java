package com.example.springboot_collegelibrary.service;

import com.example.springboot_collegelibrary.repository.BookBorrowRepository;
import com.example.springboot_collegelibrary.repository.BookDetailRepository;
import com.example.springboot_collegelibrary.repository.MoneyTransactionRepository;
import com.example.springboot_collegelibrary.dto.BorrowedBookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BookBorrowService {

    @Autowired
    BookBorrowRepository bookBorrowRepository;
    @Autowired
    BookDetailRepository bookDetailRepository;
    @Autowired
    MoneyTransactionRepository moneyTransactionRepository;
    public boolean userBorrowABook(String studentEmail, String bookId){
        BorrowedBookDTO borrowedBookDTO = new BorrowedBookDTO();
        borrowedBookDTO.setBorrowStudentEmail(studentEmail);
        borrowedBookDTO.setBorrowBookId(bookId);
        bookBorrowRepository.decreaseAvailableBookByBookId(bookId);

        int bookPrice= bookDetailRepository.selectBookDetailByBookId(bookId).getBookPrice();
        int studentBalance = moneyTransactionRepository.selectStudentBalanceWithEmail(studentEmail);
        if (studentBalance<bookPrice){
            System.out.println("BookBorrowService.userBorrowABook : Not enough point.");
            return false;
        }else{
            System.out.println("BookBorrowService.userBorrowABook : Successfully Borrowed The Book");
            bookBorrowRepository.userBorrowsBook(borrowedBookDTO);
            return true;
        }

    }

    public boolean userAlreadyBorrowedBook(String studentEmail, String bookId){
        HashMap<String,String> emailAndBookId = new HashMap<>();
        emailAndBookId.put("studentEmail",studentEmail);
        emailAndBookId.put("bookId",bookId);
        return bookBorrowRepository.userAlreadyBorrowedBook(emailAndBookId);
    }
}
