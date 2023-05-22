package com.example.demo.controller;


import com.example.demo.dto.Req;
import com.example.demo.dto.User;
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
public class ServerApiController {

    @GetMapping("/naver")
    public String naver() {

        String query = "갈비집";
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
                .queryParam("query", "대구")
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
                .header("X-Naver-Client-Id", "OVh0yxPCcFXFATWfz_7I")
                .header("X-Naver-Client-Secret", "r4k5a_3sNn")
                .build();


        // Header를 사용하기 위해서 exchange 사용용
        ResponseEntity<String> response = restTemplate.exchange(req, String.class);

        return response.getBody();
    }

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
            //HttpEntity<String> entity,
            @RequestBody Req<User> user,
            @PathVariable int userId,
            @PathVariable String userName,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("custom-header") String customHeader
    ) {
        //log.info("req : {}", entity.getBody());
        log.info("userId : {}, userName : {}", userId, userName);
        log.info("authorization : {}", authorization);
        log.info("customHeader : {}",customHeader);
        //log.info("client request : {}",user);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );
        response.setResponseBody(user.getResponseBody());
        return response;
    }

}
