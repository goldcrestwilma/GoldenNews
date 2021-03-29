package com.golden.news.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "papagoapi")
@EnableConfigurationProperties
@Setter
@Getter
public class TranslatorConfig {

    private String key;
    private String url;
    private String clientId;
}
