package com.example.springboot_collegelibrary.controller;


import com.example.springboot_collegelibrary.repository.MoneyTransactionRepository;
import com.example.springboot_collegelibrary.service.MoneyTransactionService;
import com.example.springboot_collegelibrary.aop.SkipLoginCheck;
import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class PageController {

    @Autowired
    MoneyTransactionService moneyTransactionService;
    @SkipLoginCheck
    @GetMapping("/")
    public String index(HttpSession session){
        if (session.getAttribute("email")==null) {
            return "login";
        }
        return "redirect:/searchPage";
    }

    @SkipLoginCheck
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }


    @GetMapping("/searchPage")
    public String search(Model model, HttpSession session){
        String studentEmail = (String) session.getAttribute("email");
        String fileName = studentEmail+".jpg";
        String directory = "src/main/resources/static/images/";
        File file = new File(directory, fileName);
        if (!file.exists()) {
            return "prepare";
        }

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




    @GetMapping ("/adminMenu")
    public String adminMenu(){
        return "adminMenu";
    }





    @Autowired
    MoneyTransactionRepository moneyTransactionRepository;
    @GetMapping("/testPoint")
    public String testPoint(HttpSession session){
        MoneyTransactionDTO testDTO = new MoneyTransactionDTO(session.getAttribute("email").toString(), 5000, "test", "2020-01-01");
        moneyTransactionRepository.moneyTransaction(testDTO);
        return "redirect:/";
    }
}
