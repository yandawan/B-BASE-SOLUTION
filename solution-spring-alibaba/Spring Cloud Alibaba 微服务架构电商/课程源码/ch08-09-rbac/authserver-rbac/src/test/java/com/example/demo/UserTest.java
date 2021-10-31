package com.example.demo;

import com.example.demo.mapper.PermissionMapper;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthserverrbacApplication.class)
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionMapper permissionMapper;

    // todo {数据库操作} 步骤8：测试 - 验证 mapper 数据库操作是否正常
    @Test
    public void user() {
        // 查询用户
        System.out.println(userMapper.findByUsername("admin"));
        // 查询权限
        System.out.println(permissionMapper.findByUserId(1L));
    }
}
