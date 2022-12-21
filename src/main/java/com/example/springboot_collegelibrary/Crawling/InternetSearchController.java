package com.example.springboot_collegelibrary.Crawling;

import com.example.springboot_collegelibrary.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InternetSearchController {

    @Autowired
    private InternetSearchService internetSearchService;

    @GetMapping("/Searchs")
    public List<InternetSearchDTO> Search2(@RequestParam String q) {

        System.out.println("This part works");
        System.out.println("the string q is " + q);
        // q="구글";
        try {
            return internetSearchService.search(q);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
}
