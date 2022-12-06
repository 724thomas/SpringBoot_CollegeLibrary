package com.example.springboot_collegelibrary.dto;

public class BorrowedBookDTO {

    public String borrowStudentEmail;
    public String borrowBookId;
    public String borrowedDate;
    public String returnedDate;
    public String dueDate;

    public BorrowedBookDTO() {
    }

    public BorrowedBookDTO(String borrowStudentEmail, String borrowBookId, String borrowedDate, String returnedDate, String dueDate) {
        this.borrowStudentEmail = borrowStudentEmail;
        this.borrowBookId = borrowBookId;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.dueDate = dueDate;
    }

    public String getBorrowStudentEmail() {
        return borrowStudentEmail;
    }

    public void setBorrowStudentEmail(String borrowStudentEmail) {
        this.borrowStudentEmail = borrowStudentEmail;
    }

    public String getBorrowBookId() {
        return borrowBookId;
    }

    public void setBorrowBookId(String borrowBookId) {
        this.borrowBookId = borrowBookId;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
