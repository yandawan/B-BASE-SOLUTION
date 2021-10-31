package com.example.demo.mapper;

import com.example.demo.model.ScoreDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScoreDetailMapper {
    @Select("select * from score_detail where userName=#{userId}")
    List<ScoreDetail> findScoreDetails(String userName);

    @Insert({ "insert into score_detail" +
            "(userId, userName, score, orderNo, createTime) " +
            "values" +
            "(#{userId}, #{userName}, #{score}, #{orderNo}, #{createTime, jdbcType=TIMESTAMP})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int addScore(ScoreDetail scoreDetail);
}
