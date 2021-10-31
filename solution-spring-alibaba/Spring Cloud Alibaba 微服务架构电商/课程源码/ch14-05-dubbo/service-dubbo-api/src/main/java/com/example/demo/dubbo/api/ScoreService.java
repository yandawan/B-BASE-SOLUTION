package com.example.demo.dubbo.api;

// todo [dubbo] 1. 定义积分服务接口
public interface ScoreService {
    public void addScore(String userName, Integer score, String orderNo);
}
