package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * score_user
 * @author 
 */
@Data
public class ScoreDetail implements Serializable {
    private Integer id;

    private Integer userId;

    private String userName;

    private Integer score;

    private String orderNo;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}