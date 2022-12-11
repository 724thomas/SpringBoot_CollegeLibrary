package com.example.springboot_collegelibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");

        // Format the date as a String
        String dateString = currentDate.format(formatter);

        // Print the formatted date String

        System.out.println("Formatted date: " + dateString);
    }
}
