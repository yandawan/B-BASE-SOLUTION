package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TestController {

    @Autowired
    Source source;

    // 消息内容
    private final String[] data = new String[]{
            "f", "g", "h",
            "fo", "go", "ho",
            "foo", "goo", "hoo",
            "fooz", "gooz", "hooz"
    };

    @GetMapping("/produce")
    public String produce() {
        for (int i = 0; i < 100; i++) {

            try {
                // 随机从 data 数组中获取一个字符串，作为消息内容
                Random RANDOM = new Random(System.currentTimeMillis());
                String value = data[RANDOM.nextInt(data.length)];
                System.out.println("Sending: " + value);

                // 发送消息
                source.output().send(
                        MessageBuilder.withPayload(value)
                                // 设置头信息 partitionKey，值为字符串的长度
                                .setHeader("partitionKey", value.length())
                                .build());


                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "ok";
    }
}