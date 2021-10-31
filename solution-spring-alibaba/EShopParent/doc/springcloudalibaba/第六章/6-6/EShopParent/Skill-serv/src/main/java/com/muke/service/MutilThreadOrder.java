package com.muke.service;

import com.muke.dao.SkillOrderRepository;
import com.muke.entity.SkillEntity;
import com.muke.entity.SkillGood;
import com.muke.entity.SkillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MutilThreadOrder {
    @Autowired
    private ProductService productService;
    @Autowired
    private SkillOrderRepository skillOrderRepository;
    @Autowired
    private RedisTemplate redisTemplate;
    public static final String SKILL_GOODS_QUEUE = "SKILL_GOODS_QUEUE";


    @Async
    public void createOrder() throws Exception {
        System.out.println("开始异步抢单");
        SkillEntity skillEntity = (SkillEntity) redisTemplate.boundListOps(SkillGoodService.SKILL_GOODS_LIST).rightPop();
        if (skillEntity == null) {
            return;
        }
        Long productId = skillEntity.getProductId();
        String userId = skillEntity.getUserId();
        Thread.sleep(10000);
        SkillGood skillGood = productService.getGoodById(productId);
        if (skillGood == null) {
            throw new Exception("商品已经被抢光拉");
        }
        Long size = redisTemplate.boundHashOps(SKILL_GOODS_QUEUE).size();
        SkillOrder skillOrder = new SkillOrder();
        skillOrder.setMoney(skillGood.getCostPrice());
        skillOrder.setPayTime(new Date());
        skillOrder.setStatus("0");
        skillOrder.setUserId(userId);
        skillOrder.setCreateTime(new Date());
        skillOrder.setSkillId(productId);
        skillOrderRepository.save(skillOrder);
        skillGood.setStockCount(skillGood.getStockCount() - 1);
        redisTemplate.boundHashOps(SkillGoodService.SKILL_GOODS_PHONE).put(skillGood.getId(), skillGood);
        System.out.println("成功秒杀 剩余库存：" + skillGood.getStockCount());
        if (size <= 0) {
            skillGood.setStockCount(size.intValue());
            System.out.println("库存已经是负数了:" +size);
            redisTemplate.boundHashOps(SkillGoodService.SKILL_GOODS_PHONE).delete(skillGood.getId());
            productService.update(skillGood);
        }
        System.out.println("结束异步抢单");
    }
}
