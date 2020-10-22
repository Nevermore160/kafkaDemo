package com.example.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserLogConsumer {
    @KafkaListener(topics = {"user-log"})
    public void consumer(ConsumerRecord<?,?> record){
        //判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        log.info(">>>>>>>>>>>>>> record = " + kafkaMessage);
        if (kafkaMessage.isPresent()){ //判断查询的类对象是否存在
            Object message = kafkaMessage.get();
            System.out.println("消费消息: " + message);
        }
    }
}
