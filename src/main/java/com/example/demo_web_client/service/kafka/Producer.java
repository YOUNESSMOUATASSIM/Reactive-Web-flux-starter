package com.example.demo_web_client.service.kafka;

import com.example.demo_web_client.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users1";

    @Autowired
    private KafkaTemplate<String,User> kafkaTemplate;

    public void sendMessage(User user) {
        logger.info(String.format("#### -> Producing message -> %s", user.getName()));
        this.kafkaTemplate.send(TOPIC,user);
    }
}