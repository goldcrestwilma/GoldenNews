package com.golden.news.services;

import com.golden.news.config.NewsConfig;
import com.golden.news.domain.models.NewsBody;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TopNewsService {

  private final NewsConfig newsConfig;

  @Autowired
  public TopNewsService(NewsConfig newsConfig) {
    this.newsConfig = newsConfig;
  }

  public NewsBody find() {
    RestTemplate restTemplate = new RestTemplate();
    URI url = URI.create(newsConfig.getUrl() + newsConfig.getKey());

    return restTemplate.getForObject(url, NewsBody.class);
  }
}
