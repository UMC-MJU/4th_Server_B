package umc.umccrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import umc.umccrud.domain.User;
import umc.umccrud.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/All")
    public ResponseEntity userFindAll(){
        List<User> all = userService.findAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(all);
    }
    @PostMapping("/create/{subject}")
    public ResponseEntity userCreate(@PathVariable String subject){
        userService.save(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body("만들었다.");
    }
    @PatchMapping("/update/{id}/{subject}")
    public ResponseEntity userUpdate(@PathVariable Long id,
                                     @PathVariable String subject){
        User updateUser = userService.update(id, subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);
    }
    @DeleteMapping("/delete/{subject}")
    public ResponseEntity userDelete(@PathVariable String subject){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.delete(subject));
    }
}
