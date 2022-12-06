package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.dto.BookDetailDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDetailMapper {

    public BookDetailDTO selectBookDetailByBookId(String bookId);
}
