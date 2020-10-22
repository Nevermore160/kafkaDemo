package com.example;

import com.example.Producer.UserLogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class KafkaApplication {

    @Autowired
    private UserLogProducer kafkaSender;
    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            //调用方法发送消息
            kafkaSender.sendLog(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

}
