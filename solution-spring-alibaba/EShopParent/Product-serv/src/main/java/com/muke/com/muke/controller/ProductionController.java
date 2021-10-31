package com.muke.com.muke.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ziya
 * @date 2021/2/22 12:34 上午
 */
@RestController
public class ProductionController {
    @GetMapping("/product/{productId}")
    public String getProduct(@PathVariable  Integer productId){
        System.out.println("调用商品服务");
        return "IPHONE 12";
    }
}
