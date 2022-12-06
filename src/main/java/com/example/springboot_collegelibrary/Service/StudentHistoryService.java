package com.example.springboot_collegelibrary.Service;

import com.example.springboot_collegelibrary.Repository.StudentHistoryRepository;
import com.example.springboot_collegelibrary.dto.StudentHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentHistoryService {

    @Autowired
    StudentHistoryRepository studentHistoryRepository;

    public ArrayList<StudentHistoryDTO> getStudentBorrowedBookHistory(String studentEmail){
        return studentHistoryRepository.getStudentBorrowedBookHistory(studentEmail);
    }
}
