package com.example.springboot_collegelibrary.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface SearchMapper {

    public ArrayList<HashMap<String, String>> searchBookByKeyword(String keyword);
}
