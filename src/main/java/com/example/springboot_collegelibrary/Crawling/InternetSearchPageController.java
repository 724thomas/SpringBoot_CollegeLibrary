package com.example.springboot_collegelibrary.Crawling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InternetSearchPageController {

    @GetMapping("/InternetSearchPage")
    public String searchPage() {
        return "SearchResult";
    }
}
