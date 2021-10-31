package com.example.demo.mapper;

import com.example.demo.model.ScoreDetail;
import com.example.demo.model.ScoreUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ScoreUserMapper {
    @Select("select * from score_user where userName= #{userName}")
    ScoreUser getScoreByUserName(@Param(value = "userName") String userName);

    @Insert("insert into score_user(userName, score) " +
            "values(#{userName}, #{score})")
    int addScore(ScoreDetail scoreDetail);

    @Update("update score_user set score=score+#{score} where userName=#{userName}")
    int updateScore(ScoreDetail scoreDetail);
}
