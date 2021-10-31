package com.example.demo.mapper;

import com.example.demo.model.TbOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    @Select("select * from orders where userName=#{userName}")
    List<TbOrder> findOrders(String userName);

    @Insert({ "insert into orders" +
            "(orderNo, userId, userName, amount, productName, productImage, productNum, createTime) " +
            "values" +
            "(#{orderNo}, #{userId}, #{userName}, #{amount}, #{productName}, #{productImage}, #{productNum}, #{createTime, jdbcType=TIMESTAMP})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int addOrder(TbOrder order);
}
