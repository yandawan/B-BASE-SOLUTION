package com.example.demo;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.TbOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Autowired
    OrderMapper orderMapper;

    @GetMapping("/orders")
    public List<TbOrder> orders(String username){
        // todo [资源请求] 4. 获取当前登录用户
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }else {
            username = principal.toString();
        }
        System.out.println("user:" + username);

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
