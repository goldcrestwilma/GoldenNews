package com.golden.news.domain.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Article {
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}
