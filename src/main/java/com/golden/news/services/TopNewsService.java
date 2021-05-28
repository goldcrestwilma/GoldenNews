package com.golden.news.services;

import com.golden.news.domain.models.Article;
import com.golden.news.domain.models.News;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopNewsService {

    private static final String DELIMITER = "|";
    private final Translator translator;
    private final NewsClient newsClient;

    @Autowired
    public TopNewsService(Translator translator, NewsClient newsClient) {
        this.translator = translator;
        this.newsClient = newsClient;
    }

    public List<Article> find() {
        Optional<News> news = Optional.ofNullable(newsClient.topHeadLine());

        List<Article> articleList = news.map(News::getArticles).orElse(Collections.emptyList());

        String articles = articleList
            .stream()
            .map(Article::getTitle)
            .collect(Collectors.joining(DELIMITER));

        System.out.println(articles);
        translator.translate(articles);

        return articleList;
    }
}
