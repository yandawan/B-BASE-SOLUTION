package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestController {

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + "!";
    }

    @GetMapping("/user")
    public User getUser(User user){
        return User.builder().id(1).name(user.getName()).city(user.getCity()).email("a@a.com").build();
    }
}
