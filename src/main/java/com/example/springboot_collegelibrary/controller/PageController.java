package com.example.springboot_collegelibrary.controller;


import com.example.springboot_collegelibrary.Service.MoneyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class PageController {

    @Autowired
    MoneyTransactionService moneyTransactionService;

    @GetMapping("/")
    public String index(HttpSession session){
        if (session.getAttribute("email")==null) {
            return "login";
        }
        return "searchpage";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/searchPage")
    public String search(HttpSession session){
//        session.setAttribute("balance",moneyTransactionService.selectStudentBalanceWithEmail(session.getAttribute("email").toString()));
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

    @GetMapping("/kakaologin")
    public String kakaologin(@RequestParam HashMap<String,String> kakaologin){
        System.out.println(kakaologin.keySet());
        System.out.println(kakaologin.values());
        return "redirect:/";
    }
}
