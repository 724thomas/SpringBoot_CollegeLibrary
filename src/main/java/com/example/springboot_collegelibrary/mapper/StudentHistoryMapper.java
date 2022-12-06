package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.dto.StudentHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface StudentHistoryMapper {

    public ArrayList<StudentHistoryDTO> getStudentBorrowedBookHistory(String studentEmail);
}
