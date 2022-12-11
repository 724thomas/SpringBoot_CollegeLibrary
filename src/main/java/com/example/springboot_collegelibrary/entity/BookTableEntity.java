package com.example.springboot_collegelibrary.entity;

public class BookTableEntity {
    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private int bookQuantity;
    private int bookAvailable;
    private int bookPrice;

    public BookTableEntity() {
    }

    public BookTableEntity(String bookId, String bookTitle, String bookAuthor, int bookQuantity, int bookAvailable, int bookPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookQuantity = bookQuantity;
        this.bookAvailable = bookAvailable;
        this.bookPrice = bookPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public int getBookAvailable() {
        return bookAvailable;
    }

    public int getBookPrice() {
        return bookPrice;
    }
}
