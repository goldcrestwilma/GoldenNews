package com.golden.news.services;

import com.golden.news.config.NewsConfig;
import com.golden.news.domain.models.Article;
import com.golden.news.domain.models.News;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopNewsService {

    private static final String DELIMITER = "|";
    private final NewsConfig newsConfig;
    private final Translator translator;
    private final NewsClient newsClient;

    @Autowired
    public TopNewsService(NewsConfig newsConfig, Translator translator, NewsClient newsClient) {
        this.newsConfig = newsConfig;
        this.translator = translator;
        this.newsClient = newsClient;
    }

    public News find() {
        News news = newsClient.topHeadLine();

        List<Article> articleList = news.getArticles();
        //.orElse(Collections.emptyList());

        String articles = articleList
            .stream()
            .map(Article::getTitle)
            .collect(Collectors.joining(DELIMITER));

        translator.translate(articles);

        return news;

//        return newsClient.topHeadLine();
    }
}
