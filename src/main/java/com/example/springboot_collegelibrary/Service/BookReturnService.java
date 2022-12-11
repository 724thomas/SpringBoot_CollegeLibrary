package com.example.springboot_collegelibrary.Service;

import com.example.springboot_collegelibrary.Repository.BookReturnRepository;
import com.example.springboot_collegelibrary.dto.StudentTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static java.lang.Math.min;
import static sun.swing.MenuItemLayoutHelper.max;

@Service
public class BookReturnService {

    @Autowired
    BookReturnRepository bookReturnRepository;
    public int userReturnABook(String studentEmail, String bookId){
        int returnedStudentPoint = calculateReturnPoint(studentEmail,bookId);// 학생의 반환될 포인트
        bookReturnRepository.increaseAvailableBookByBookId(bookId); // 책의 대여가능 수량을 1 증가.
        insertBookReturnedDate(studentEmail, bookId); // 학생의 반날일자 추가
        updateStudentBalance(studentEmail,returnedStudentPoint); // student.balance + returnPoint
        return 0;
    }

    public int updateStudentBalance(String studentEmail, int returnedPoint){
        StudentTableDTO studentTableDTO = new StudentTableDTO();
        studentTableDTO.setStudentEmail(studentEmail);
        int balance = returnedPoint + bookReturnRepository.getStudentBalanceByStudentEmail(studentEmail);
        studentTableDTO.setBalance(balance);
        return bookReturnRepository.updateStudentBalance(studentTableDTO);
    }

    public int insertBookReturnedDate(String studentEmail, String bookId){
        HashMap<String,String> emailBookIdAndReturnedDate = new HashMap<>();
        emailBookIdAndReturnedDate.put("studentEmail",studentEmail);
        emailBookIdAndReturnedDate.put("bookId",bookId);
        emailBookIdAndReturnedDate.put("returnedDate", getCurrentDate());
        return bookReturnRepository.insertBookReturnedDate(emailBookIdAndReturnedDate);
    }

    public int calculateReturnPoint(String studentEmail, String bookId){
        HashMap<String,String> studentEmailAndBookId = new HashMap<>();
        studentEmailAndBookId.put("studentEmail",studentEmail);
        studentEmailAndBookId.put("bookId",bookId);

        int bookPrice = bookReturnRepository.getBookPriceByBookId(bookId);
        String bookDueDate = bookReturnRepository.getBookDueDateByStudentEmailAndBookId(studentEmailAndBookId);
        int dateDifference = calculateDateDifference(bookDueDate,getCurrentDate());
        int lateFee;
        if (dateDifference <= 0){
            lateFee=0;
        }
        else {
            lateFee= min(dateDifference * (int)(bookPrice * 0.1),bookPrice);
        }
        return bookPrice - lateFee;
    }

    public String getCurrentDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        return currentDate.format(formatter);
    }

    public int calculateDateDifference(String startDate, String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(startDate, formatter);
        LocalDate localDate2 = LocalDate.parse(endDate, formatter);
        return localDate1.until(localDate2).getDays();
    }
}
