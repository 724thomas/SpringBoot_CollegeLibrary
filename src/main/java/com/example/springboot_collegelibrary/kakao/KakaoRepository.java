package com.example.springboot_collegelibrary.kakao;

import com.example.springboot_collegelibrary.dto.StudentTableDTO;
import com.example.springboot_collegelibrary.entity.StudentTableEntity;
import com.example.springboot_collegelibrary.mapper.KakaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KakaoRepository {
    @Autowired
    KakaoMapper kakaoMapper;

    public int insertKakaoSignup(StudentTableDTO studentTableDTO) {
        return kakaoMapper.insertKakaoSignup(studentTableDTO);
    }

    public StudentTableEntity selectStudentByEmail(String studentEmail) {
        return kakaoMapper.selectStudentByEmail(studentEmail);
    }
}
