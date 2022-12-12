package com.example.springboot_collegelibrary.entity;

public class MoneyTransactionInfoTableEntity {

    private String studentEmail;
    private int amountTransaction;
    private String uid;
    private String transactionDate;

    public MoneyTransactionInfoTableEntity() {
    }

    public MoneyTransactionInfoTableEntity(String studentEmail, int amountTransaction, String uid, String transactionDate) {
        this.studentEmail = studentEmail;
        this.amountTransaction = amountTransaction;
        this.uid = uid;
        this.transactionDate = transactionDate;
    }

    public String getStudentEmail() {
        return studentEmail;
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
