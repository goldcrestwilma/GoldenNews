package com.golden.news.services;

import com.golden.news.config.TranslatorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class Translator {

    private final TranslatorConfig translatorConfig;

    @Autowired
    public Translator(TranslatorConfig translatorConfig) {
        this.translatorConfig = translatorConfig;
    }

    public void translate(String text) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("source", "en");
        params.add("target", "ko");
        params.add("text", text);

        httpHeaders.add("X-Naver-Client-Id", translatorConfig.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", translatorConfig.getKey());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, httpHeaders);

        ResponseEntity<String> response = restTemplate
            .exchange(translatorConfig.getUrl(), HttpMethod.POST, entity, String.class);

        System.out.println(response.getBody());


    }

}
