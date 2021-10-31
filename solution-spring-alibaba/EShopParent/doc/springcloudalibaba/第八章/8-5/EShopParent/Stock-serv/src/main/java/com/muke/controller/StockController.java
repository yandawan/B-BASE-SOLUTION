package com.muke.controller;

import com.muke.dao.StockRespority;
import com.muke.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


/**
 * @author ziya
 * @date 2021/2/22 12:50 上午
 */
@RestController
public class StockController {
    @Autowired
    private StockRespority respority;
    @Autowired
    private Random random;

    @GetMapping("/stock/reduce/{productId}")
    public String reduce(@PathVariable Integer productId) {
        if(random.nextBoolean()){
            throw new RuntimeException("这是mock的错误");
        }
        Stock stock = respority.getFirstByProductId(productId);
        if (stock == null) {
            return "fail";
        }
        stock.setCount(stock.getCount() - 1);
        respority.save(stock);
        return "success";
    }
}
