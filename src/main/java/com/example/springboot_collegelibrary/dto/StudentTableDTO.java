package com.example.springboot_collegelibrary.dto;

public class StudentTableDTO {

    private String studentNumber;
    private String studentEmail;
    private String studentPassword;
    private String studentName;
    private String studentPhone;
    private int Balance;
    private int lateFee;

    public StudentTableDTO() {
    }

    public StudentTableDTO(String studentNumber, String studentEmail, String studentPassword, String studentName, String studentPhone, int balance, int lateFee) {
        this.studentNumber = studentNumber;
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.Balance = balance;
        this.lateFee = lateFee;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public int getLateFee() {
        return lateFee;
    }

    public void setLateFee(int lateFee) {
        this.lateFee = lateFee;
    }
}
