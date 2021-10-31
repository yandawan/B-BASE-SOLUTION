package com.muke.controller;

import com.muke.entity.AdEntity;
import com.muke.service.ADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ADController {
    @Autowired
    private ADService adService;

    @GetMapping("/ad/getADList")
    @ResponseBody
    public List<AdEntity> getADList() {
        return adService.getADList();
    }
}
