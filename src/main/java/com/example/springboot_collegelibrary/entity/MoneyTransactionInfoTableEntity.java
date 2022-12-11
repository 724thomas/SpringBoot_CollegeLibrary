package com.example.springboot_collegelibrary.entity;

public class MoneyTransactionInfoTableEntity {

    private String studentEmail;
    private int amountTransaction;
    private String uid;

    public MoneyTransactionInfoTableEntity() {
    }

    public MoneyTransactionInfoTableEntity(String studentEmail, int amountTransaction, String uid) {
        this.studentEmail = studentEmail;
        this.amountTransaction = amountTransaction;
        this.uid = uid;
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
}
