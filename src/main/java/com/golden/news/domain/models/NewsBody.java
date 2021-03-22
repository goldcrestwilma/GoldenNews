package com.golden.news.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsBody {
    @JsonProperty("status")
    private String status;
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("articles")
    private List<Article> articles;
}
