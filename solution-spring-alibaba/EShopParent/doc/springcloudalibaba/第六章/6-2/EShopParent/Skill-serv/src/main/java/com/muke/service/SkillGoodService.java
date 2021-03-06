package com.muke.service;

import com.muke.dao.SkillOrderRepository;
import com.muke.entity.SkillGood;
import com.muke.entity.SkillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class SkillGoodService {
    public static final String SKILL_GOODS_PHONE = "SKILL_GOODS_PHONE";
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SkillOrderRepository skillOrderRepository;
    @Autowired
    private ProductService productService;


    @Transactional
    public void add(Long productId, String userId) throws Exception {

        SkillGood skillGood = productService.getGoodById(productId);
        if (skillGood == null) {
            throw new Exception("商品已经被抢光拉");
        }
        if (skillGood.getStockCount() > 0) {
            SkillOrder skillOrder = new SkillOrder();
            skillOrder.setMoney(skillGood.getCostPrice());
            skillOrder.setPayTime(new Date());
            skillOrder.setStatus("0");
            skillOrder.setUserId(userId);
            skillOrder.setCreateTime(new Date());
            skillOrder.setSkillId(productId);
            skillOrderRepository.save(skillOrder);
            skillGood.setStockCount(skillGood.getStockCount() - 1);
            redisTemplate.boundHashOps(SKILL_GOODS_PHONE).put(skillGood.getId(), skillGood);
            System.out.println("成功秒杀 剩余库存："+skillGood.getStockCount());
        }
        if (skillGood.getStockCount() <= 0) {
            System.out.println("库存已经是负数了:" + skillGood.getStockCount());
            redisTemplate.boundHashOps(SKILL_GOODS_PHONE).delete(skillGood.getId());
            productService.update(skillGood);
        }
    }
}
