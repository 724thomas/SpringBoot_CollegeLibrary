package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface StudentMapper {
    public HashMap<String,String> selectStudentByEmail(String studentEmail);

    public int studentSignUp(HashMap<String, String> student);
}
