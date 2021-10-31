package com.example.demo;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.TbProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    ProductMapper productMapper;

    @GetMapping("/products")
    public List<TbProduct> products(){
        return productMapper.findProducts();
    }

    @GetMapping("/product")
    public TbProduct product(Long id){
        return productMapper.getProductById(id);
    }
}
