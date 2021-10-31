package com.example.demo;

import brave.propagation.ExtraFieldPropagation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hi")
    public String hi() {
        // todo Provider 步骤2：取出包裹
        return "hi " + ExtraFieldPropagation.get("BaggageId");
    }

}
