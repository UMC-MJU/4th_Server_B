package com.example.umc_api.controller;


import com.example.umc_api.dto.putUserRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/put")
public class PutApiController {

    @PutMapping("/umc")
    public void put(@RequestBody putUserRequest putuser){
        System.out.println(putuser);
    }

}
