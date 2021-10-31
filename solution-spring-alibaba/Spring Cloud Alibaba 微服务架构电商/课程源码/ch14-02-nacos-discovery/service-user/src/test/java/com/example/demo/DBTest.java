package com.example.demo;

import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceuserApplication.class)
public class DBTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
//        System.out.println(productMapper.findProducts());
        System.out.println(userMapper.findByUsername("test"));
    }
}
