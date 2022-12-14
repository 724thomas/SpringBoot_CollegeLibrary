package com.example.springboot_collegelibrary.controller.student;

import com.example.springboot_collegelibrary.faceRecognition.FaceService;
import com.example.springboot_collegelibrary.service.MoneyTransactionService;
import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MoneyTransactionController {

    @Autowired
    private MoneyTransactionService moneyTransactionService;
    @Autowired
    private FaceService faceService;

    @GetMapping("/depositPoint")
    public String depositPoint(@ModelAttribute MoneyTransactionDTO moneyTransactionDTO, HttpSession session) {
        moneyTransactionDTO.setEmail(String.valueOf(session.getAttribute("email")));
        moneyTransactionService.moneyTransaction(moneyTransactionDTO);
        return "redirect:/";
    }

    @PostMapping("/goWithdraw")
    public String goWithdraw(@RequestParam int withdrawAmount, HttpSession session) {
        MoneyTransactionDTO tempDTO = new MoneyTransactionDTO();
        tempDTO.setEmail(String.valueOf(session.getAttribute("email")));
        tempDTO.setAmountTransaction(-withdrawAmount);
        tempDTO.setUid("randomWithdrawId");
        String recognitionResult = faceService.FaceSimilarityVideoAndPicture(String.valueOf(session.getAttribute("email")));
        if (!recognitionResult.equals("Correct Face detected")) {
            System.out.println("Different face detected");
            return "redirect:/logout";
        }

        if (moneyTransactionService.moneyTransaction(tempDTO).equals("Success")) {
            return "redirect:/";
        } else {
            return "redirect:/logout";
        }
    }
}
