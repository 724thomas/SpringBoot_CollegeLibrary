package com.example.springboot_collegelibrary.repository;

import com.example.springboot_collegelibrary.dto.BorrowedBookDTO;
import com.example.springboot_collegelibrary.mapper.BookBorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BookBorrowRepository {

    @Autowired
    BookBorrowMapper bookBorrowMapper;

    public int decreaseAvailableBookByBookId(String bookId){
        return bookBorrowMapper.decreaseAvailableBookByBookId(bookId);
    }

    public int userBorrowsBook(BorrowedBookDTO borrowedBookDTO){
        return bookBorrowMapper.userBorrowsBook(borrowedBookDTO);
    }

    public boolean userAlreadyBorrowedBook(HashMap<String,String> emailAndBookId){
        return bookBorrowMapper.userAlreadyBorrowedBook(emailAndBookId)!=null;
    }
}
