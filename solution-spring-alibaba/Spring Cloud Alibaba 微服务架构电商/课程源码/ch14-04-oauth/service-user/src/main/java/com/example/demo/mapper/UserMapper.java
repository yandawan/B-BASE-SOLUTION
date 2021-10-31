package com.example.demo.mapper;

import com.example.demo.model.TbUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

// todo [登录] 2. 数据库操作，根据用户名查询用户信息
public interface UserMapper {
    @Select("select * from tb_user where username=#{username}")
    TbUser findByUsername(@Param(value = "username") String username);
}