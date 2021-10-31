package com.muke.controller;

import com.muke.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author ziya
 * @date 2021/2/20 3:58 下午
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IStockService stockService;

    @GetMapping("/order/create")
    public String createOrder(Integer productId, Integer userId) {
//        String result=restTemplate.getForObject("http://stock-serv/stock/reduce/"+productId,String.class);
        String result=stockService.reduce(productId);
        return result;
    }
}
