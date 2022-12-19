package com.example.springboot_collegelibrary.faceRecognition;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FaceController {

    @Autowired
    FaceService faceService;

    @GetMapping("/face")
    public String face(Model model){
        faceService.TakePicture("Test.jpg");
        model.addAttribute("imageUrl", "/images/Test.jpg");
        return "image-page";
    }
}
