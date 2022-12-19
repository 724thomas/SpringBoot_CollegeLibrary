package com.example.springboot_collegelibrary.kakao;

import com.example.springboot_collegelibrary.dto.StudentTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class KakaoService {
    @Autowired
    KakaoRepository kakaoRepository;

    public int insertKakaoSignup(HashMap<String, String> student,String studentEmail) {
        StudentTableDTO studentTableDTO = new StudentTableDTO();
        studentTableDTO.setStudentEmail(studentEmail);
        studentTableDTO.setStudentNumber(student.get("studentNumber"));
        studentTableDTO.setStudentPassword(student.get("studentPassword"));
        studentTableDTO.setStudentName(student.get("studentName"));
        studentTableDTO.setStudentPhone(student.get("studentPhone"));
        studentTableDTO.setBalance(0);
        studentTableDTO.setLatefee(0);
        return kakaoRepository.insertKakaoSignup(studentTableDTO);
    }

    public boolean studentAlreadySignedUp(String studentEmail) {
        return kakaoRepository.selectStudentByEmail(studentEmail)!=null;
    }
}
