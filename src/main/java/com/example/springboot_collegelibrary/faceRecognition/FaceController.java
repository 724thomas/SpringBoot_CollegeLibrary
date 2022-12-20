package com.example.springboot_collegelibrary.faceRecognition;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Controller
public class FaceController {

    @Autowired
    FaceService faceService;

    @GetMapping("/face")
    public String face(Model model, HttpSession session) {
        String studentEmail = (String)session.getAttribute("email");
        studentEmail="724thomas@hanmail.net";
//        faceService.TakePicture(studentEmail);
        faceService.TakePictureAndDetectFace(studentEmail);
        faceService.cutOnlyFace(studentEmail);
//        faceService.FaceSimilarityVideoAndPicture(studentEmail);
        // Correct Face detected / Wrong face detected / Error opening video stream
        model.addAttribute("imageUrl", "images/"+studentEmail+".jpg");
        return "image-page";
    }

    @GetMapping("/faceCheck")
    public String faceCheck(Model model, HttpSession session){
        String studentEmail = (String)session.getAttribute("email");
        studentEmail="724thomas@hanmail.net";
//        faceService.TakePicture(studentEmail);
        String result = faceService.FaceSimilarityVideoAndPicture(studentEmail);
        // Correct Face detected / Wrong face detected / Error opening video stream
        model.addAttribute("faceCheck", result);
        return "image-check";
    }
}
