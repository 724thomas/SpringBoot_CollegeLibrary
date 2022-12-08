package com.example.springboot_collegelibrary.dto;

public class MoneyTransactionDTO {
    private String email;
    private int amountTransaction;
    private String uid;
    private String transactionDate;

    public MoneyTransactionDTO() {
    }

    public MoneyTransactionDTO(String email, int amountTransaction, String uid, String transactionDate) {
        this.email = email;
        this.amountTransaction = amountTransaction;
        this.uid = uid;
        this.transactionDate = transactionDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(int amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
