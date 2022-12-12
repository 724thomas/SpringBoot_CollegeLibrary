package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.dto.StudentTableDTO;
import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KakaoMapper {

    public int insertKakaoSignup(StudentTableDTO studentTableDTO);
    public StudentTableEntity selectStudentByEmail(String studentEmail);
}
