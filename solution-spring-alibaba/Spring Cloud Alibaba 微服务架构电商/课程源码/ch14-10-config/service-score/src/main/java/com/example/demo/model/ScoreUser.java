package com.example.demo.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class ScoreUser implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer score;

    private String userName;

    private static final long serialVersionUID = 1L;
}