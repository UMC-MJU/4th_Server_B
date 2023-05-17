package com.example.umc_api.controller;

import com.example.umc_api.dto.UserRequest;
import com.example.umc_api.dto.postUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostApiController {

    @PostMapping("/umc")
    public void umcPost(@RequestBody postUserRequest postuserrequest){
        System.out.println(postuserrequest);
    }
}
