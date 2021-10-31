package com.example.demo;

import com.example.demo.mapper.ScoreDetailMapper;
import com.example.demo.mapper.ScoreUserMapper;
import com.example.demo.model.ScoreDetail;
import com.example.demo.model.ScoreUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class TestController {
    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @Autowired
    ScoreUserMapper scoreUserMapper;

    @Autowired
    ScoreDetailMapper scoreDetailMapper;

    @GetMapping("/score")
    public Map<String, Object> score(String username) {

        log.info("username: {}", username);

        ScoreUser score = scoreUserMapper.getScoreByUserName(username);
        List<ScoreDetail> scoreDetails = scoreDetailMapper.findScoreDetails(username);
        Map<String, Object> result = new HashMap<>();
        result.put("score", score);
        result.put("scoreDetails", scoreDetails);
        return result;
    }

    @GetMapping ("/addscore")
    public void addscore(ScoreDetail scoreDetail){
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
