package com.tyron.consumer;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TestConsumer {

    @KafkaListener(topics = {"test1"}, groupId = "tyron")
    public void testC1(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) throws InterruptedException {
        for(ConsumerRecord record : records){
            Optional<Object> kafkaMassage = Optional.ofNullable(record.value());
            if(kafkaMassage.isPresent()){
                Object o = kafkaMassage.get();
                System.out.println("testC1：" + o);
            }
        }
        Thread.sleep(1000 * 10);
        System.out.println("testC1===============================================");
        ack.acknowledge();
    }

    @KafkaListener(topics = {"test1"}, groupId = "tyron")
    public void testC2(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) throws InterruptedException {
        for(ConsumerRecord record : records){
            Optional<Object> kafkaMassage = Optional.ofNullable(record.value());
            if(kafkaMassage.isPresent()){
                Object o = kafkaMassage.get();
                System.out.println("testC2：" + o);
            }
        }
        Thread.sleep(1000 * 10);
        System.out.println("testC2===============================================");
        ack.acknowledge();
    }

    @KafkaListener(topics = {"test1"}, groupId = "koma")
    public void testC3(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) throws InterruptedException {
        for(ConsumerRecord record : records){
            Optional<Object> kafkaMassage = Optional.ofNullable(record.value());
            if(kafkaMassage.isPresent()){
                Object o = kafkaMassage.get();
                System.out.println("testC3：" + o);
            }
        }
        Thread.sleep(1000 * 3);
        System.out.println("testC3===============================================");
        ack.acknowledge();
    }

}
