package com.example.demo.mapper;

import com.example.demo.model.TbUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    // todo {数据库操作} 步骤6：- 根据 username 查询用户信息
    @Select("select * from tb_user where username=#{username}")
    TbUser findByUsername(@Param(value = "username") String username);
}
