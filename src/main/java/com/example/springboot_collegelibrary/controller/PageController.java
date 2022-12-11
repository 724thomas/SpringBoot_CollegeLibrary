package com.example.springboot_collegelibrary.controller;


import com.example.springboot_collegelibrary.Repository.MoneyTransactionRepository;
import com.example.springboot_collegelibrary.Service.MoneyTransactionService;
import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import com.example.springboot_collegelibrary.dto.testDTO;
import com.example.springboot_collegelibrary.mapper.BookReturnMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class PageController {

    @Autowired
    MoneyTransactionService moneyTransactionService;

    @GetMapping("/")
    public String index(HttpSession session){
        System.out.println("PageController.index : Email : " + session.getAttribute("email"));
        if (session.getAttribute("email")==null) {
            return "login";
        }
        return "redirect:/searchPage";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/searchPage")
    public String search(Model model, HttpSession session){
        String userEmail=(String)session.getAttribute("email");
        model.addAttribute("email", userEmail);
        model.addAttribute("balance", moneyTransactionService.selectStudentBalanceWithEmail(userEmail));
        return "searchpage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("email",null);
        return "redirect:/";
    }

    @GetMapping("/instructionpopup")
    public String instructionPopUp(HttpSession session){
        return "instructionpopup";
    }

    @GetMapping("/goDeposit")
    public String goPay(){
        return "deposit";
    }

    @GetMapping("/goWithdraw")
    public String goWithdraw(){
        return "withdraw";
    }

    @GetMapping("/goTotalTransaction")
    public String goTotalTransaction(HttpSession session, Model model){
        String userEmail=(String)session.getAttribute("email");
        model.addAttribute("totalTransactionDTOList", moneyTransactionService.selectStudentTotalTransactionByEmail(userEmail));
        return "studentTotalTransaction";
    }
}
