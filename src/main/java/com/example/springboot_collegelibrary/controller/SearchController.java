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
        try{
            return searchService.searchBookByKeyword(keyword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
