package com.tyron;

import com.tyron.producer.TestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
public class KafkaApplication {

    @Autowired
    private TestProducer product;
    @PostConstruct
    public void init(){
        for(int i=0;i<10;i++){
            product.sendTest(i);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

}
