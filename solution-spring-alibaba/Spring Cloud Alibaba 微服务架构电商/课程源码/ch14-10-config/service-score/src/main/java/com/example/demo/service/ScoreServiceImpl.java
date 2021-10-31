package com.example.demo.service;

import com.example.demo.dubbo.api.ScoreService;
import com.example.demo.mapper.ScoreDetailMapper;
import com.example.demo.mapper.ScoreUserMapper;
import com.example.demo.model.ScoreDetail;
import com.example.demo.model.ScoreUser;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreUserMapper scoreUserMapper;

    @Autowired
    ScoreDetailMapper scoreDetailMapper;

    @Override
    public void addScore(String userName, Integer score, String orderNo) {
        ScoreDetail scoreDetail = new ScoreDetail();
        scoreDetail.setUserName(userName);
        scoreDetail.setScore(score);
        scoreDetail.setOrderNo(orderNo);

        ScoreUser scoreByUserName = scoreUserMapper.getScoreByUserName(scoreDetail.getUserName());
        if(scoreByUserName == null) {
            scoreUserMapper.addScore(scoreDetail);
        }else{
            scoreUserMapper.updateScore(scoreDetail);
        }

        scoreDetail.setCreateTime(new Date(System.currentTimeMillis()));
        scoreDetailMapper.addScore(scoreDetail);
    }
}
