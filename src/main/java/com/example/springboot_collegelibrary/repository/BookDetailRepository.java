package com.example.springboot_collegelibrary.repository;

import com.example.springboot_collegelibrary.dto.BookDetailDTO;
import com.example.springboot_collegelibrary.mapper.BookDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDetailRepository {

    @Autowired
    BookDetailMapper bookDetailMapper;

    public BookDetailDTO selectBookDetailByBookId(String bookId){
        return bookDetailMapper.selectBookDetailByBookId(bookId);
    }

}
