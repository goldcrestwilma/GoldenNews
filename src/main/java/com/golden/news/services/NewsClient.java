package com.golden.news.services;

import com.golden.news.domain.models.News;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "news-api", url = "${newsapi.url}")
public interface NewsClient {

    @GetMapping("/top-headlines?sources=bbc-news&apiKey=${newsapi.key}")
    News topHeadLine();

}
