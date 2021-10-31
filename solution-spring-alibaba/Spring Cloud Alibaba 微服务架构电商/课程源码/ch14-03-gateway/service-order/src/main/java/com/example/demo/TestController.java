package com.example.demo;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.TbOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class TestController {

    @Autowired
    OrderMapper orderMapper;

    @GetMapping("/orders")
    public List<TbOrder> orders(String username){
        return orderMapper.findOrders(username);
    }

    @PostMapping("/order")
    public String order(HttpServletRequest request, @RequestBody TbOrder order){

        order.setOrderNo(Long.toString(System.currentTimeMillis()));
        order.setCreateTime(new Date(System.currentTimeMillis()));
        System.out.println(order);
        orderMapper.addOrder(order);
        return "ok";
    }


}
