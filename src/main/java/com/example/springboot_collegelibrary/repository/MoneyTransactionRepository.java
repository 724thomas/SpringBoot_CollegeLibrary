package com.example.springboot_collegelibrary.repository;

import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import com.example.springboot_collegelibrary.mapper.MoneyTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MoneyTransactionRepository {

    @Autowired
    private MoneyTransactionMapper moneyTransactionMapper;

    public int moneyTransaction(MoneyTransactionDTO moneyTransactionDTO) {
        return moneyTransactionMapper.moneyTransaction(moneyTransactionDTO) +
                moneyTransactionMapper.updateStudentBalance(moneyTransactionDTO);
    }

    public int selectStudentBalanceWithEmail(String email) {
        return moneyTransactionMapper.selectStudentBalanceWithEmail(email);
    }

    public ArrayList<MoneyTransactionDTO> selectStudentTotalTransactionByEmail(String email) {
        return moneyTransactionMapper.selectStudentTotalTransactionByEmail(email);
    }
}
