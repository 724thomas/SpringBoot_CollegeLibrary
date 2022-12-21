package com.example.springboot_collegelibrary.faceRecognition;


import org.opencv.face.Face;
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


    @GetMapping("/loading")
    public String loading() {
        return "loading";
    }


    @GetMapping("/faceResult")
    public String face(HttpSession session) {
        String studentEmail = (String)session.getAttribute("email");

        String recognitionResult="";
        while (!recognitionResult.equals("Correct Face detected")){
            faceService.TakePictureAndDetectFace(studentEmail);
            faceService.cutOnlyFace(studentEmail);
            recognitionResult = faceService.FaceSimilarityVideoAndPicture(studentEmail);
        }


        // Correct Face detected / Wrong face detected / Error opening video stream

        return "redirect:/";
    }

    @GetMapping("/faceCheck")
    public String faceCheck(Model model, HttpSession session){
        String studentEmail = (String)session.getAttribute("email");
//        faceService.TakePicture(studentEmail);
        String result = faceService.FaceSimilarityVideoAndPicture(studentEmail);
        // Correct Face detected / Wrong face detected / Error opening video stream
        model.addAttribute("faceCheck", result);
        return "image-check";
    }
}
