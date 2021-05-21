package com.golden.news.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Translator {

    //private final TranslatorConfig translatorConfig;
    private final PapagoClient papagoClient;

    public void translate(String text) {
        String params = "source=en&target=ko&text=" + text;
        /*
        Map<String, String> params =
            params.put("source", "en");
        params.put("target", "ko");
        params.put("text", text);

         */
        ResponseEntity<String> response = papagoClient.translate(params);
        System.out.println(response.getBody());

        /*
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("X-Naver-Client-Id", translatorConfig.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", translatorConfig.getKey());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, httpHeaders);

        ResponseEntity<String> response = restTemplate
            .exchange(translatorConfig.getUrl(), HttpMethod.POST, entity, String.class);

        System.out.println(response.getBody());

         */

    }

}
