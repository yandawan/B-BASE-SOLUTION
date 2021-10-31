package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TbOrder implements Serializable {
    private Integer id;

    private String orderNo;

    private Integer userId;

    private String userName;

    private Double amount;

    private String productName;

    private String productImage;

    private Integer productNum;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}