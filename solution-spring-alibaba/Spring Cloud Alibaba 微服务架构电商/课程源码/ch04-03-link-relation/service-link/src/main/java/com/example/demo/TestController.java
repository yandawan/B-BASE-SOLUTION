package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private CommonService commonService;

    @GetMapping("/testa")
    public String testa() {
        return "test a : " + commonService.getName();
    }
    @GetMapping("/testb")
    public String testb() {
        return "test b : " + commonService.getName();
    }

}
