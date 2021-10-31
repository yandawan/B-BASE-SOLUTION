package com.muke.service;

import com.muke.entity.AdEntity;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.handler.EntryHandler;

@Component
public class ADHandle implements EntryHandler<AdEntity> {
    @Override
    public void insert(AdEntity adEntity) {
        System.out.println(adEntity.getName());
    }

    @Override
    public void update(AdEntity before, AdEntity after) {

    }

    @Override
    public void delete(AdEntity adEntity) {

    }
}
