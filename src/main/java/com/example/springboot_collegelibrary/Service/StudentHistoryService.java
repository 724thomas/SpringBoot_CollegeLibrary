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
        ArrayList<StudentHistoryDTO> temp = new ArrayList<>();
        for(StudentHistoryDTO dto : studentHistoryRepository.getStudentBorrowedBookHistory(studentEmail)){
            if(dto.getReturnedDate() == null){
                dto.setReturnedDate("대여 중");
                temp.add(dto);
            }
        }
        return temp;
    }

    public ArrayList<StudentHistoryDTO> getStudentCurrentBorrowList(String studentEmail){
        ArrayList<StudentHistoryDTO> temp = new ArrayList<>();
        for(StudentHistoryDTO dto : studentHistoryRepository.getStudentBorrowedBookHistory(studentEmail)){
            if(dto.getReturnedDate() != null){
                temp.add(dto);
            }
        }
        return temp;
    }
}
