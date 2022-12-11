package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.dto.StudentTableDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface BookReturnMapper {

    public int getBookPriceByBookId(String bookId);
    public String getBookDueDateByStudentEmailAndBookId(HashMap<String,String> studentEmailAndBookId);
    public int increaseAvailableBookByBookId(String bookId);
    public int insertBookReturnedDate (HashMap<String,String> emailBookIdAndReturnedDate);
    public int updateStudentBalance(StudentTableDTO studentTableDTO);
    public int getStudentBalanceByStudentEmail(String studentEmail);
}
