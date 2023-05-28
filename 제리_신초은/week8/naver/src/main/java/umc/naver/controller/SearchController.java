package umc.naver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class SearchController {

    @GetMapping("/naver")
    public String naver() {

        String query = "명지대";
        String encode = Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8));

        // https://openapi.naver.com
        // /v1/search/local.json
        // ?query=%EA%B0%88%EB%B9%84%EC%A7%91
        // &display=10
        // &start=1
        // &sort=random
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", "명지대")
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode()
                .build()
                .toUri();

        log.info("uri : {}", uri);
        RestTemplate restTemplate = new RestTemplate();

        // HEADER를 추가하기 위해서 RequestEntity 사용
        // Get으로 넣을것이기 때문에 Void로 지정
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "kUjjuohvl_L5UObNjk4f")
                .header("X-Naver-Client-Secret", "ZEX90dZrQy")
                .build();


        // Header를 사용하기 위해서 exchange 사용용
        ResponseEntity<String> response = restTemplate.exchange(req, String.class);

        return response.getBody();
    }

}