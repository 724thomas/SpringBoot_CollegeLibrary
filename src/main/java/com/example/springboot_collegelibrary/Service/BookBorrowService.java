package com.example.springboot_collegelibrary.Service;

import com.example.springboot_collegelibrary.Repository.BookBorrowRepository;
import com.example.springboot_collegelibrary.dto.BorrowedBookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowService {

    @Autowired
    BookBorrowRepository bookBorrowRepository;

    public int userBorrowABook(String studentEmail, String bookId){
        BorrowedBookDTO borrowedBookDTO = new BorrowedBookDTO();
        borrowedBookDTO.setBorrowStudentEmail(studentEmail);
        borrowedBookDTO.setBorrowBookId(bookId);
        bookBorrowRepository.decreaseAvailableBookByBookId(bookId);
        return bookBorrowRepository.userBorrowsBook(borrowedBookDTO);
    }
}
