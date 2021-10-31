package com.example.demo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @CrossOrigin
    @RequestMapping("/api/userinfo")
    public String getUerInfo() {
        String principal = (String)SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return principal;
    }

}