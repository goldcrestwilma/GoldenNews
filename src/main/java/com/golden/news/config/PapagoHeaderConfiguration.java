package com.golden.news.config;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class PapagoHeaderConfiguration {

    private final TranslatorConfig translatorConfig;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-Naver-Client-Id", translatorConfig.getClientId());
            requestTemplate.header("X-Naver-Client-Secret", translatorConfig.getKey());
            requestTemplate
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        };
    }

}
