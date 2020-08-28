package com.tyron.producer;

import com.alibaba.fastjson.JSON;
import com.tyron.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Component
public class TestProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendTest(Integer num){
        User user = new User("tyron" + num, 24, "北京大兴");
        try {
//            Thread.sleep(1000 * 4);
            ListenableFuture<SendResult> a = (ListenableFuture<SendResult>) kafkaTemplate.send("test1", JSON.toJSONString(user));
            a.addCallback(
                    successCallBack -> log.info("发送失败"),
                    failCallBack -> log.info("发送成功"));
            /*log.info("22行----------{}", System.currentTimeMillis());
//            Thread.sleep(1000 * 2);
            log.info("发送结果：{}", a.toString());
            log.info("24行----------{}", System.currentTimeMillis());*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        //如果需要消费者有顺序需要发送到同一个partition
//        kafkaTemplate.send("test1", 0, null, JSON.toJSONString(user));
    }
}
