package com.golden.news.web;

import com.golden.news.domain.models.News;
import com.golden.news.services.TopNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class IndexController {

    private final TopNewsService topNewsService;

    @GetMapping("/api/v1/top10")
    public News top10() {
        return topNewsService.find();
    }
}
