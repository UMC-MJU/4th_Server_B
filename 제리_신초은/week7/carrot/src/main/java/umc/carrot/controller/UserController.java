package umc.carrot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import umc.carrot.dto.UserRequestDto;
import umc.carrot.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user")
    public ResponseEntity<?> joinUser(@RequestBody UserRequestDto requestDto) {
        System.out.println("User Controller - joinUser start");
        return userService.join(requestDto);
    }

    //회원 조회
    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> searchUser(@PathVariable(value = "user_id") Long user_id) {
        return userService.findOne(user_id);
    }


}
