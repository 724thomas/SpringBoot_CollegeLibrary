package com.example.springboot_collegelibrary.Repository;

import com.example.springboot_collegelibrary.dto.BorrowedBookDTO;
import com.example.springboot_collegelibrary.mapper.BookBorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
