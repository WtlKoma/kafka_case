package com.tyron.producer;

import com.alibaba.fastjson.JSON;
import com.tyron.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendTest(Integer num){
        User user = new User("tyron" + num, 24, "北京大兴");
        kafkaTemplate.send("user1", JSON.toJSONString(user));
    }
}
