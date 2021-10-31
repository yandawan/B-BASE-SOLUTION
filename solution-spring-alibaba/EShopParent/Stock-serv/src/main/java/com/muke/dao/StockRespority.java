package com.muke.dao;

import com.muke.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRespority extends JpaRepository<Stock, Integer> {
    public Stock getFirstByProductId(Integer productId);
}

