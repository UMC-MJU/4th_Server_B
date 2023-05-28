package com.example.umc_api.controller;


import com.example.umc_api.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

        @GetMapping(path = "/umc")
        //경로path를 지정해주는 방법
        //http://localhost:8080/api/get/umc
        public String getUmc(){
            return "get UMC Page";
        }
        @RequestMapping(path = "/umc2",method = RequestMethod.GET)
        //http 메서드 get post delete등에서 get메서드를 사용하겠다
        //http://localhost:8080/api/get/umc2
        public String getUmc2(){
            return "get UMC2 Page";
        }
        @GetMapping("/path-variable/{name}")
        //http://localhost:8080/api/get/path-variable/{name}
        //받은 name에 따라서 달라지는 path-Variable을 이용한 메서드
        public String pathVariable(@PathVariable String name){
            return name;
        }
        @GetMapping(path = "query-param")
        //http://localhost:8080/api/get/query-param?key=value
        public String queryParam(@RequestParam Map<String ,String> queryParam){
            StringBuilder sb = new StringBuilder();

            queryParam.entrySet().forEach(entry -> {
                sb.append("엔트리의 키값은 : "+entry.getKey()+" 그리고 엔트리의 벨류값은 "+entry.getValue()+"\n");
            });
            return sb.toString();

        }
        @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
        ){
            return "name = "+name +" email = "+email +" age = "+age;
        }
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
            //객체를 받아 올때는 어노테이션 RequestParam은 쓰지 않는다.
        return userRequest.toString();
    }
}
