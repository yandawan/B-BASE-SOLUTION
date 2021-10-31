package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

// todo {数据库操作} 步骤4：创建实体类 - 用户
@Data
public class TbUser implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private static final long serialVersionUID = 1L;
}