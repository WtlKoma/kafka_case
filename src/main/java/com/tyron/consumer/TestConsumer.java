package com.tyron.consumer;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TestConsumer {

    @KafkaListener(topics = {"user1"})
    public void testC(ConsumerRecord record){
        Optional<Object> kafkaMassage = Optional.ofNullable(record.value());
        if(kafkaMassage.isPresent()){
            Object o = kafkaMassage.get();
            System.out.println(o);
        }
    }

}
