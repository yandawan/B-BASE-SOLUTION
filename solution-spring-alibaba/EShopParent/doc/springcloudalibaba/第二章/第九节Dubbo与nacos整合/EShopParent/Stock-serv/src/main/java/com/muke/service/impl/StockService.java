package com.muke.service.impl;

import com.muke.IStockService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0",group = "ziya")
public class StockService implements IStockService {
    @Override
    public String reduce(Integer productId) {
        return "减库存1个";
    }
}
