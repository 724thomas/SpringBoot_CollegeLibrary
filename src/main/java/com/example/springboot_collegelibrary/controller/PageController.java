package com.example.springboot_collegelibrary.controller;


import com.example.springboot_collegelibrary.Repository.MoneyTransactionRepository;
import com.example.springboot_collegelibrary.Service.MoneyTransactionService;
import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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
        System.out.println("PageController.search : Email : " + session.getAttribute("email"));
        return "searchpage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("email",null);
        System.out.println("PageController.logout : Email : " + session.getAttribute("email"));
        return "redirect:/";
    }

    @GetMapping("/instructionpopup")
    public String instructionPopUp(HttpSession session){
        System.out.println("PageController.instructionPopUp : Popup Success");
        return "instructionpopup";
    }

    @GetMapping("/goDeposit")
    public String goPay(){
        System.out.println("PageController.goPay : Go to Deposit Page");
        return "deposit";
    }

    @GetMapping("/goWithdraw")
    public String goWithdraw(){
        System.out.println("PageController.goWithdraw : Go to Withdraw Page");
        return "withdraw";
    }

    @GetMapping("/goTotalTransaction")
    public String goTotalTransaction(HttpSession session, Model model){
        String userEmail=(String)session.getAttribute("email");
        model.addAttribute("totalTransactionDTOList", moneyTransactionService.selectStudentTotalTransactionByEmail(userEmail));
        System.out.println("PageController.goTotalTransaction : Go to Total Transaction Page");
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
