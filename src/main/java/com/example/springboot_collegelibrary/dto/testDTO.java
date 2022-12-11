package com.example.springboot_collegelibrary.dto;

public class testDTO {
    private String email;
    private int amountTransaction;
    private String uid;
    private String transactionDate;

    public testDTO() {
    }

    public testDTO(String email, int amountTransaction, String uid, String transactionDate) {
        this.email = email;
        this.amountTransaction = amountTransaction;
        this.uid = uid;
        this.transactionDate = transactionDate;
    }

    public String getEmail() {
        return email;
    }

    public int getAmountTransaction() {
        return amountTransaction;
    }


    public String getUid() {
        return uid;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

}
