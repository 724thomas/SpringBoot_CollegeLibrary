package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoneyTransactionMapper {
    public int moneyTransaction(MoneyTransactionDTO moneyTransactionDTO);
    public int updateStudentBalance(MoneyTransactionDTO moneyTransactionDTO);
}
