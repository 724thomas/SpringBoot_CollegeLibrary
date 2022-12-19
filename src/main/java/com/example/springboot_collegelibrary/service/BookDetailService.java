package com.example.springboot_collegelibrary.service;

import com.example.springboot_collegelibrary.repository.BookDetailRepository;
import com.example.springboot_collegelibrary.dto.BookDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDetailService {

    @Autowired
    BookDetailRepository bookDetailRepository;

    public BookDetailDTO selectBookDetailByBookId(String bookId){
        return bookDetailRepository.selectBookDetailByBookId(bookId);
    }

}
