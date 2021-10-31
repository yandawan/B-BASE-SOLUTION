package com.example.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @SentinelResource("getName")
    public String getName(){
        return "dell";
    }
}
