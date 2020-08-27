package com.tyron.controller;

import com.tyron.producer.TestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestProducer producer;

    @GetMapping("test")
    public String test(Integer num){
        for (int i = 0; i < num; i++) {
            producer.sendTest(i);
        }
        return "success";
    }

}
