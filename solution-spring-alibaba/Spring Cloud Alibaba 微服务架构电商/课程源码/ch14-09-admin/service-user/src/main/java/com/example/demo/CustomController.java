package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomController {
    @Autowired
    ConsumerTokenServices consumerTokenServices;

    @DeleteMapping("/api/logout")
    public boolean logout(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("Token"))
                {
                    return consumerTokenServices.revokeToken(cookie.getValue());
                }
            }
        }
        return false;
    }
}
