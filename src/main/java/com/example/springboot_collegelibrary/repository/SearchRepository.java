package com.example.springboot_collegelibrary.repository;

import com.example.springboot_collegelibrary.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class SearchRepository {

    @Autowired
    SearchMapper searchMapper;

    public ArrayList<HashMap<String,String>> searchBookByKeyword(String keyword){
        return searchMapper.searchBookByKeyword(keyword);
    }

}
