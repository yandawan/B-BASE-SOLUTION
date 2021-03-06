package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbUser implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private static final long serialVersionUID = 1L;
}