package com.example.demo;

import com.example.demo.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceproductApplication.class)
public class DBTest {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void test(){
//        System.out.println(productMapper.findProducts());
        System.out.println(productMapper.getProductById(1L));
    }
}
