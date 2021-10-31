package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient(name="service-provider")
public interface HelloService {
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name);

    @GetMapping("/user")
    public User getUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("city") String city,
                        @RequestParam("email") String email);


    @RequestMapping(value="/uploadFile", method = RequestMethod.POST,
        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart(value = "file") MultipartFile file);
}
