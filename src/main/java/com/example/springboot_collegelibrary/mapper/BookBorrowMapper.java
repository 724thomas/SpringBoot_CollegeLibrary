package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.dto.BorrowedBookDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookBorrowMapper {
    public int decreaseAvailableBookByBookId(String bookId);
    public int userBorrowsBook(BorrowedBookDTO borrowedBookDTO);
}
