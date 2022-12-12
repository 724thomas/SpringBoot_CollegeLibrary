package com.example.springboot_collegelibrary.entity;

public class BorrowedBookTableEntity {
    private String studentEmail;
    private String bookId;
    private String borrowedDate;
    private String returnedDate;
    private String dueDate;


    public BorrowedBookTableEntity() {
    }

    public BorrowedBookTableEntity(String studentEmail, String bookId, String borrowedDate, String returnedDate, String dueDate) {
        this.studentEmail = studentEmail;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.dueDate = dueDate;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public String getDueDate() {
        return dueDate;
    }
}
