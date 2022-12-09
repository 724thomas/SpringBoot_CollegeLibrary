package com.example.springboot_collegelibrary.Service;

import com.example.springboot_collegelibrary.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SearchService {

    @Autowired
    SearchRepository searchRepository;

    public ArrayList<HashMap<String,String>> searchBookByKeyword(String keyword){
        return searchRepository.searchBookByKeyword(keyword);
    }
}
