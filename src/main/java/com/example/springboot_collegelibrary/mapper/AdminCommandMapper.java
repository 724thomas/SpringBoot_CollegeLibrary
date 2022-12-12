package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AdminCommandMapper {

    public ArrayList<StudentTableEntity> getAllStudents();
    public ArrayList<StudentTableEntity> searchStudentByKeyword(String keyword);
    public int deleteStudentByStudentEmail(String studentEmail);
}
