package com.example.demo;

import com.example.demo.dubbo.api.ScoreService;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.TbOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
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
    public List<TbOrder> orders(String username) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        System.out.println("user:" + username);

        return orderMapper.findOrders(username);
    }

    // todo [dubbo] 3. 引用 dubbo 服务 ScoreService
    @Reference(check = false)
    ScoreService scoreService;

    @PostMapping("/order")
    public String order(HttpServletRequest request, @RequestBody TbOrder order) {
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        order.setUserName(username);
        order.setOrderNo(Long.toString(System.currentTimeMillis()));
        order.setCreateTime(new Date(System.currentTimeMillis()));
        System.out.println(order);
        orderMapper.addOrder(order);

        // todo [dubbo] 4. 调用 score service
        int score_val = (new Double(order.getAmount() / 10)).intValue();
        scoreService.addScore(username, score_val, order.getOrderNo());

        return "ok";
    }


}
