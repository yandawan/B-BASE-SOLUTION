package com.example.demo.mapper;

import com.example.demo.model.TbProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    @Select("select * from product")
    List<TbProduct> findProducts();

    @Select("select * from product where id= #{id}")
    TbProduct getProductById(@Param(value = "id") Long id);
}
