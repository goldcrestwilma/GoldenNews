package com.golden.news.services;

import com.golden.news.config.FeignSimpleEncoderConfig;
import com.golden.news.config.PapagoHeaderConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "papago-api", url = "${papagoapi.url}", configuration = {
    FeignSimpleEncoderConfig.class,
    PapagoHeaderConfiguration.class
})
public interface PapagoClient {

    @PostMapping("/papago/n2mt")
    ResponseEntity<String> translate(
        @RequestBody String params
    );

}
