package com.example.springboot_collegelibrary.repository;

import com.example.springboot_collegelibrary.dto.StudentTableDTO;
import com.example.springboot_collegelibrary.entity.BorrowedBookTableEntity;
import com.example.springboot_collegelibrary.entity.LateFeesTableEntity;
import com.example.springboot_collegelibrary.mapper.BookReturnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BookReturnRepository {

    @Autowired
    BookReturnMapper bookReturnMapper;

    public int getBookPriceByBookId(String bookId){
        return bookReturnMapper.getBookPriceByBookId(bookId);
    }

    public String getBookDueDateByStudentEmailAndBookId(HashMap<String,String> studentEmailAndBookId){
        return bookReturnMapper.getBookDueDateByStudentEmailAndBookId(studentEmailAndBookId);
    }

    public int increaseAvailableBookByBookId(String bookId){
        return bookReturnMapper.increaseAvailableBookByBookId(bookId);
    }

    public int insertBookReturnedDate (HashMap<String,String> emailBookIdAndReturnedDate){
        return bookReturnMapper.insertBookReturnedDate(emailBookIdAndReturnedDate);
    }

    public int updateStudentBalance(StudentTableDTO studentTableDTO){
        return bookReturnMapper.updateStudentBalance(studentTableDTO);
    }

    public int getStudentBalanceByStudentEmail(String studentEmail){
        return bookReturnMapper.getStudentBalanceByStudentEmail(studentEmail);
    }

    public int insertLatefees(LateFeesTableEntity lateFeesTableEntity){
        return bookReturnMapper.insertLatefees(lateFeesTableEntity);
    }

    public BorrowedBookTableEntity selectBorrowedBookByStudentEmailAndBookId(HashMap<String,String> studentEmailAndBookId){
        return bookReturnMapper.selectBorrowedBookByStudentEmailAndBookId(studentEmailAndBookId);
    }
}
