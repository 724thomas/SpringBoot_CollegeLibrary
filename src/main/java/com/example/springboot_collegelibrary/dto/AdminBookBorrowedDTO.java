package com.example.springboot_collegelibrary.dto;

public class AdminBookBorrowedDTO {
    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private String borrowedDate;
    private String returnedDate;
    private String studentNumber;
    private String studentEmail;
    private String studentName;
    private String studentPhone;

    public AdminBookBorrowedDTO() {
    }

    public AdminBookBorrowedDTO(String bookId, String bookTitle, String bookAuthor, String borrowedDate, String returnedDate, String studentNumber, String studentEmail, String studentName, String studentPhone) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.studentNumber = studentNumber;
        this.studentEmail = studentEmail;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
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
}
