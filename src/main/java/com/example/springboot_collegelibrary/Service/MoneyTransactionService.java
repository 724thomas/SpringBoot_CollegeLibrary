package com.example.springboot_collegelibrary.Service;

import com.example.springboot_collegelibrary.Repository.MoneyTransactionRepository;
import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoneyTransactionService {

    @Autowired
    private MoneyTransactionRepository moneyTransactionRepository;

    public String moneyTransaction(MoneyTransactionDTO moneyTransactionDTO) {
        if (moneyTransactionRepository.selectStudentBalanceWithEmail(moneyTransactionDTO.getEmail()) + moneyTransactionDTO.getAmountTransaction() >= 0) {
            moneyTransactionRepository.moneyTransaction(moneyTransactionDTO);
            return "Success";
        }
        return "Fail";
    }

    public int selectStudentBalanceWithEmail(String email) {
        return moneyTransactionRepository.selectStudentBalanceWithEmail(email);
    }

    public ArrayList<MoneyTransactionDTO> selectStudentTotalTransactionByEmail(String email) {
        return moneyTransactionRepository.selectStudentTotalTransactionByEmail(email);
    }
}
