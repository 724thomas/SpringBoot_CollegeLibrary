package com.example.springboot_collegelibrary.Kakao;

import com.example.springboot_collegelibrary.dto.StudentTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class KakaoController {
    @Autowired
    KakaoService kakaoService;

    @GetMapping("/kakaoSignup")
    public String kakaoSignup(HttpSession session, Model model){
        String studentEmail=session.getAttribute("email").toString();
        model.addAttribute("email", studentEmail);
        if (kakaoService.studentAlreadySignedUp(studentEmail)){
            System.out.println("KakaoController.kakaoSignup : " + studentEmail + " already signed Up");
            return "redirect:/";
        }else{
            System.out.println("KakaoController.kakaoSignup : " + studentEmail + " not signed Up. Go to kakao signup page");
            return "kakaoSignup";
        }
    }
    @PostMapping("/kakaoSignup")
    public String kakaoSignup(@RequestParam HashMap<String,String> student, HttpSession session) {
        kakaoService.insertKakaoSignup(student, session.getAttribute("email").toString());
        System.out.println("KakaoController.kakaoSignup : Kakao Signup Success.");
        return "redirect:/kakaoSignup";
    }
}
