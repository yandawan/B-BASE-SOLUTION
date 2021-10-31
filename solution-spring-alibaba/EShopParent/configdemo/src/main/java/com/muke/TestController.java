package com.muke;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ziya
 * @date 2021/3/2 12:19 上午
 */
@RestController
@RefreshScope
public class TestController {
    @Value("${testStr}")
    private String  testStr;

    @Value("${testProd}")
    private String  testProd;

    @Value("${testCommon}")
    private String  testCommon;

    @Value("${redis}")
    private String  redis;

    @Value("${mq}")
    private String  mq;

    @GetMapping("/test")
    public String test(){
        return testStr;
    }

    @GetMapping("/testProd")
    public String testProd(){
        return testProd;
    }

    @GetMapping("/testCommon")
    public String testCommon(){
        return testCommon;
    }

    @GetMapping("/redis")
    public String redis(){
        return redis;
    }

    @GetMapping("/mq")
    public String mq(){
        return mq;
    }

}
