package com.muke.dao;

import com.muke.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRespority extends JpaRepository<Order,Integer> {
}
