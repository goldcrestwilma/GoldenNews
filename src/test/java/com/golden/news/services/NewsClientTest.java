package com.golden.news.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.golden.news.domain.models.News;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NewsClientTest {

    @Autowired
    NewsClient newsClient;

    @Test
    @DisplayName("feign 이용하여 뉴스 탑10 API 호출")
    void topHeadLine_호출() {
        News news = newsClient.topHeadLine();

        assertEquals("ok", news.getStatus());
        assertThat(news, is(notNullValue()));
    }

}