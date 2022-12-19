package com.example.springboot_collegelibrary.repository;

import com.example.springboot_collegelibrary.dto.StudentHistoryDTO;
import com.example.springboot_collegelibrary.mapper.StudentHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class StudentHistoryRepository {

    @Autowired
    StudentHistoryMapper studentHistoryMapper;

    public ArrayList<StudentHistoryDTO> getStudentBorrowedBookHistory(String studentEmail){
        return studentHistoryMapper.getStudentBorrowedBookHistory(studentEmail);
    }
}
