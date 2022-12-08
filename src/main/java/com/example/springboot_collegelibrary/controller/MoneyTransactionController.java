package com.example.springboot_collegelibrary.controller;

import com.example.springboot_collegelibrary.Service.MoneyTransactionService;
import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class MoneyTransactionController {

    @Autowired
    private MoneyTransactionService moneyTransactionService;

    @GetMapping("/depositPoint")
    public String depositPoint(@ModelAttribute MoneyTransactionDTO moneyTransactionDTO, HttpSession session) {
        moneyTransactionDTO.setEmail(String.valueOf(session.getAttribute("email")));
        moneyTransactionService.moneyTransaction(moneyTransactionDTO);
        System.out.println("MoneyTransactionService.moneyTransaction : 잔여 포인트가 부족합니다.");
        System.out.println("MoneyTransactionController.depositPoint : " + moneyTransactionDTO.getEmail() + " 님의 결제가 완료되었습니다.");
        System.out.println("MoneyTransactionController.depositPoint : " + moneyTransactionDTO.getAmountTransaction() + " 포인트가 충전되었습니다.");
        System.out.println("MoneyTransactionController.depositPoint : " + moneyTransactionDTO.getUid() + " 결제번호입니다.");
        return "redirect:/";
    }

    @PostMapping("/goWithdraw")
    public String goWithdraw(@RequestParam int withdrawAmount, HttpSession session) {
        MoneyTransactionDTO tempDTO = new MoneyTransactionDTO();
        tempDTO.setEmail(String.valueOf(session.getAttribute("email")));
        tempDTO.setAmountTransaction(-withdrawAmount);
        tempDTO.setUid("randomWithdrawId");
        if (moneyTransactionService.moneyTransaction(tempDTO).equals("Success")) {
            System.out.println("MoneyTransactionController.goWithdraw : " + tempDTO.getEmail() + " 님의 출금이 완료되었습니다.");
            System.out.println("MoneyTransactionController.goWithdraw : " + tempDTO.getAmountTransaction() + " 포인트가 출금되었습니다.");
            System.out.println("MoneyTransactionController.goWithdraw : " + tempDTO.getUid() + " 출금번호입니다.");
            return "redirect:/";
        } else {
            System.out.println("MoneyTransactionController.goWithdraw : 잔여 포인트가 부족합니다.");
            return "redirect:/goWithdraw";
        }
    }
}
