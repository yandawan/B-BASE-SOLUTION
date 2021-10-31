package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

// todo {数据库操作} 步骤5：创建实体类 - 权限
@Data
public class TbPermission implements Serializable {
    private Long id;

    private Long parentId;

    private String name;

    private String enname;

    private String url;

    private String description;

    private static final long serialVersionUID = 1L;
}