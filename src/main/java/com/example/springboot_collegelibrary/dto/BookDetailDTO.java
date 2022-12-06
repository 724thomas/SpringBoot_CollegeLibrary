package com.example.springboot_collegelibrary.dto;

public class BookDetailDTO {
    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private int bookQuantity;
    private int bookAvailable;
    private int bookPrice;

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

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getBookAvailable() {
        return bookAvailable;
    }

    public void setBookAvailable(int bookAvailable) {
        this.bookAvailable = bookAvailable;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public BookDetailDTO(String bookId, String bookTitle, String bookAuthor, int bookQuantity, int bookAvailable, int bookPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookQuantity = bookQuantity;
        this.bookAvailable = bookAvailable;
        this.bookPrice = bookPrice;
    }
}
