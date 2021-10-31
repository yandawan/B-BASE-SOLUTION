package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    Source source;

    @Autowired
    MySource mySource;

    @GetMapping("testmysource")
    public String testmysource(String msg){
        mySource.output().send(MessageBuilder.withPayload(msg).build());
        return "ok";
    }

    @GetMapping("teststream")
    public String teststream(String msg){
        source.output().send(MessageBuilder.withPayload(msg)
                .setHeader("test-header", "my test").build());
        return "ok";
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + "!";
    }
}
