package com.example.springboot_collegelibrary.service;

import com.example.springboot_collegelibrary.repository.BookReturnRepository;
import com.example.springboot_collegelibrary.dto.StudentTableDTO;
import com.example.springboot_collegelibrary.entity.BorrowedBookTableEntity;
import com.example.springboot_collegelibrary.entity.LateFeesTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static java.lang.Math.min;

@Service
public class BookReturnService {

    @Autowired
    BookReturnRepository bookReturnRepository;
    public int userReturnABook(String studentEmail, String bookId){
        int returnedStudentPoint = calculateReturnPoint(studentEmail,bookId);// 학생의 반환될 포인트
        System.out.println("BookReturnService.userReturnABook : " + returnedStudentPoint + " points returned.");
        bookReturnRepository.increaseAvailableBookByBookId(bookId); // 책의 대여가능 수량을 1 증가.
        System.out.println("BookReturnService.userReturnABook : Increase Book Available by 1.");
        insertLatefees(studentEmail,bookId); // 연체료 테이블에 연체료 정보를 저장.
        System.out.println("BookReturnService.userReturnABook : Insert into latefees table if exists.");
        insertBookReturnedDate(studentEmail, bookId); // 학생의 반날일자 추가
        System.out.println("BookReturnService.userReturnABook : Added returned Date");
        updateStudentBalance(studentEmail,returnedStudentPoint); // 학생의 포인트 업데이트
        System.out.println("BookReturnService.userReturnABook : Update Student balance.");
        return 0;
    }


    public int updateStudentBalance(String studentEmail, int returnedPoint){
        StudentTableDTO studentTableDTO = new StudentTableDTO();
        studentTableDTO.setStudentEmail(studentEmail);
        int balance = returnedPoint + bookReturnRepository.getStudentBalanceByStudentEmail(studentEmail);
        studentTableDTO.setBalance(balance);
        return bookReturnRepository.updateStudentBalance(studentTableDTO);
    }
    public int calculateReturnPoint(String studentEmail, String bookId){
        int lateFee = calculateLatefee(studentEmail,bookId);
        int bookPrice = bookReturnRepository.getBookPriceByBookId(bookId);
        return bookPrice - lateFee;
    }
    public int calculateLatefee(String studentEmail, String bookId){
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
        return lateFee;
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


    public int insertBookReturnedDate(String studentEmail, String bookId){
        HashMap<String,String> emailBookIdAndReturnedDate = new HashMap<>();
        emailBookIdAndReturnedDate.put("studentEmail",studentEmail);
        emailBookIdAndReturnedDate.put("bookId",bookId);
        emailBookIdAndReturnedDate.put("returnedDate", getCurrentDate());
        return bookReturnRepository.insertBookReturnedDate(emailBookIdAndReturnedDate);
    }

    //Todo : 연체료가 발생했을때 LatefeeTable에 db가 들어가도록 수정해야됨.
    public int insertLatefees(String studentEmail, String bookId){
        HashMap<String,String> studentEmailAndBookId = new HashMap<>();
        studentEmailAndBookId.put("studentEmail",studentEmail);
        studentEmailAndBookId.put("bookId",bookId);

        BorrowedBookTableEntity borrowedBookTableEntity = bookReturnRepository.selectBorrowedBookByStudentEmailAndBookId(studentEmailAndBookId);
        String currentDate = getCurrentDate();
        int lateFee = calculateLatefee(studentEmail,bookId);
        if (lateFee == 0){
            return 0;
        }
        else {
            String borrowedDate = borrowedBookTableEntity.getBorrowedDate();
            String returnedDate = currentDate;
            LateFeesTableEntity lateFeesTableEntity = new LateFeesTableEntity(studentEmail,bookId,borrowedDate,returnedDate,lateFee);
            return bookReturnRepository.insertLatefees(lateFeesTableEntity);
        }
    }
}
