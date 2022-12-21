package com.example.springboot_collegelibrary;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        String fileName = "724thomas@hanmail.net.jpg";
        String directory = "src/main/resources/static/images/";

        File file = new File(directory, fileName);
        if (file.exists()) {
            System.out.println("File exists!");
        } else {
            System.out.println("File does not exist.");
        }
    }

}
