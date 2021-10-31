package com.example.demo.mapper;

import com.example.demo.model.TbUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from tb_user where username=#{username}")
    TbUser findByUsername(@Param(value = "username") String username);
}