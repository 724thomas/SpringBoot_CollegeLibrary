package com.example.springboot_collegelibrary.mapper;

import com.example.springboot_collegelibrary.dto.MoneyTransactionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MoneyTransactionMapper {
    public int moneyTransaction(MoneyTransactionDTO moneyTransactionDTO);
    public int updateStudentBalance(MoneyTransactionDTO moneyTransactionDTO);
    public int selectStudentBalanceWithEmail(String email);
    public ArrayList<MoneyTransactionDTO> selectStudentTotalTransactionByEmail(String email);

}
