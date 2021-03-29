package com.golden.news.services;

import com.golden.news.config.NewsConfig;
import com.golden.news.domain.models.Article;
import com.golden.news.domain.models.NewsBody;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TopNewsService {

    private final NewsConfig newsConfig;
    private final Translator translator;

    @Autowired
    public TopNewsService(NewsConfig newsConfig, Translator translator) {
        this.newsConfig = newsConfig;
        this.translator = translator;
    }

    public NewsBody find() {
        RestTemplate restTemplate = new RestTemplate();
        URI url = URI.create(newsConfig.getUrl() + newsConfig.getKey());

        Optional<NewsBody> newsBody = Optional
            .ofNullable(restTemplate.getForObject(url, NewsBody.class));
        List<Article> articleList = newsBody.map(NewsBody::getArticles)
            .orElse(Collections.emptyList());

        articleList.forEach(a -> {
            System.out.println(a.getContent());
            translator.translate(a.getContent());
        });

        return restTemplate.getForObject(url, NewsBody.class);
    }
}
