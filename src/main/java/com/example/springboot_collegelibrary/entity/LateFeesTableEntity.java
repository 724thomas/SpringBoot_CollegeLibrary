package com.example.springboot_collegelibrary.entity;

public class LateFeesTableEntity {

    private String studentEmail;
    private String bookId;
    private String borrowedDate;
    private String returnedDate;
    private int latefee;

    public LateFeesTableEntity() {
    }

    public LateFeesTableEntity(String studentEmail, String bookId, String borrowedDate, String returnedDate, int latefee) {
        this.studentEmail = studentEmail;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.latefee = latefee;
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

    public int getLatefee() {
        return latefee;
    }
}
