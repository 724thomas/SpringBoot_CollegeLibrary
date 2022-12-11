package com.example.springboot_collegelibrary.entity;

public class StudentTableEntity {
    private String studentNumber;
    private String studentEmail;
    private String studentPassword;
    private String studentName;
    private String studentPhone;
    private int balance;
    private int latefee;

    public StudentTableEntity() {
    }

    public StudentTableEntity(String studentNumber, String studentEmail, String studentPassword, String studentName, String studentPhone, int balance, int latefee) {
        this.studentNumber = studentNumber;
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.balance = balance;
        this.latefee = latefee;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public int getBalance() {
        return balance;
    }

    public int getLatefee() {
        return latefee;
    }
}
