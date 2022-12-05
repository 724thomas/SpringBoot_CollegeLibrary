package com.example.springboot_collegelibrary.controller;

import com.example.springboot_collegelibrary.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/searchs")
    public ArrayList<HashMap<String,String>> searchBook(@RequestParam String keyword){


        System.out.println("This Part Works");
        try{
            System.out.println("This Part Works2");
            System.out.println(keyword);
            return searchService.searchBookByKeyword(keyword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
