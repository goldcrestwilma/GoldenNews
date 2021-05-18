package com.golden.news.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class News {

    @JsonProperty("status")
    private String status;
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("articles")
    private List<Article> articles;
}
