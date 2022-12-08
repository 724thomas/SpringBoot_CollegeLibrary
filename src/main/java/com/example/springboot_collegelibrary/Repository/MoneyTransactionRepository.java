package com.example.springboot_collegelibrary.Repository;

import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import com.example.springboot_collegelibrary.mapper.MoneyTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MoneyTransactionRepository {

    @Autowired
    private MoneyTransactionMapper moneyTransactionMapper;

    public int moneyTransaction(MoneyTransactionDTO moneyTransactionDTO) {
        return moneyTransactionMapper.moneyTransaction(moneyTransactionDTO) +
                moneyTransactionMapper.updateStudentBalance(moneyTransactionDTO);
    }
}
