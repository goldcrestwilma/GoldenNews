package com.golden.news.services;

import com.golden.news.config.NewsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class TopNewsService {

    private final NewsConfig newsConfig;

    @Autowired
    public TopNewsService(NewsConfig newsConfig) {
        this.newsConfig = newsConfig;
    }

    public String find() {
        RestTemplate restTemplate = new RestTemplate();
        URI url = URI.create(newsConfig.getUrl() + newsConfig.getKey());

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        return responseEntity.getBody();
    }
}
