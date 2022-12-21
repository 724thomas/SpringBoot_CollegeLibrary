package com.example.springboot_collegelibrary.Crawling;

import org.springframework.stereotype.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InternetSearchService {

    public List<InternetSearchDTO> search(String keyword) throws IOException {
        String URL = "https://www.google.com/search?q="+keyword.replace(" ","+");
        List<InternetSearchDTO> internetSearchDTOS = new ArrayList<>();
        Document doc;
        System.out.println(keyword);
        try{
            doc=Jsoup.connect(URL).get();
            Elements total = doc.select("div.MjjYud");
            for (int i=0; i<total.size();  i++){
                Elements title = total.get(i).select("h3.LC20lb.MBeuO.DKV0Md");
                Elements url = total.get(i).select("div").select("div.kvH3mc.BToiNc.UK95Uc").select("div.Z26q7c.UK95Uc.jGGQ5e a");
                Elements description = total.get(i).select("div.VwiC3b.yXK7lf.MUxGbd.yDYNvb.lyLwlc.lEBKkf");
                if (title.text().equals("") | url.attr("href").equals("") | description.text().equals("")){
                    System.out.println("one is null");
                }else{
                    InternetSearchDTO tempDTO = new InternetSearchDTO(title.text(),url.attr("href"),description.text());
                    internetSearchDTOS.add(tempDTO);
                }

            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return internetSearchDTOS;
    }

    public List<InternetSearchDTO> search2(String keyword) throws IOException {
        String URL = "https://www.google.com/search?q="+keyword.replace(" ","+");
        Document doc;
        List<InternetSearchDTO> internetSearchDTOS = new ArrayList<>();
        try{
            doc = Jsoup.connect(URL).get();
            Elements titles = doc.select("div.MjjYud").select("div.g.Ww4FFb.vt6azd.tF2Cxc").select("h3.LC20lb.MBeuO.DKV0Md");
            Elements urls = doc.select("div.MjjYud").select("div.Z26q7c.UK95Uc.jGGQ5e a");
            Elements description = doc.select("div.MjjYud").select("div.g.Ww4FFb.vt6azd.tF2Cxc").select("div.VwiC3b.yXK7lf.MUxGbd.yDYNvb.lyLwlc.lEBKkf");

            System.out.println(titles.size() + "개 " + urls.size() + "개 " + description.size() +"개");
            if (titles.size()!= urls.size()){
                System.out.println("제목과 링크 길이 다름"); return null;
            }
            if (urls.size()!= description.size()){
                System.out.println("링크와 설명 길이 다름"); return null;
            }
            if (description.size()!= titles.size()){
                System.out.println("제목과 설명 길이 다름"); return null;
            }
//
//            for (int i = 0; i<titles.size(); i++){
//                System.out.println(titles.get(i).text());
//            }
//            for (int i = 0; i<urls.size(); i++){
//                System.out.println(urls.get(i).attr("href"));
//            }
//            for (int i = 0; i<description.size(); i++){
//                System.out.println(description.get(i).text());
//            }

            for (int i=0; i<titles.size(); i++){
                InternetSearchDTO tempDTO = new InternetSearchDTO(titles.get(i).text(),urls.get(i).attr("href"),description.get(i).text());
                internetSearchDTOS.add(tempDTO);
            }
            return internetSearchDTOS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
