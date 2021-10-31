package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbProduct implements Serializable {
    private Long id;
    private String name;
    private Double price;
    private String image;
    private String description;
}
