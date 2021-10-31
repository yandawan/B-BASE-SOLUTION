package com.muke.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ziya
 * @date 2021/2/22 12:50 上午
 */
@RestController
public class StockController {
    @GetMapping("/stock/reduce/{productId}")
    public String reduce(@PathVariable  Integer productId){
        System.out.println("减库存1个成功");
        return "减库存1个成功";
    }
}
