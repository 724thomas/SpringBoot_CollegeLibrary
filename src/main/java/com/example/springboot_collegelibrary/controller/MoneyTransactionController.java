package com.example.springboot_collegelibrary.controller;

import com.example.springboot_collegelibrary.Service.MoneyTransactionService;
import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class MoneyTransactionController {

    @Autowired
    private MoneyTransactionService moneyTransactionService;

    @GetMapping("/depositPoint")
    public String depositPoint(@ModelAttribute MoneyTransactionDTO moneyTransactionDTO, HttpSession session) {
        moneyTransactionDTO.setEmail(String.valueOf(session.getAttribute("email")));
        System.out.println(moneyTransactionDTO.getEmail() + " 님의 결제가 완료되었습니다.");
        System.out.println(moneyTransactionDTO.getAmountTransaction() + " 포인트가 충전되었습니다.");
        System.out.println(moneyTransactionDTO.getUid() + " 결제번호입니다.");
        moneyTransactionService.moneyTransaction(moneyTransactionDTO);
        return "redirect:/";
    }
}
