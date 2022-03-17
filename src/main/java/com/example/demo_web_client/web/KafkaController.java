package com.example.demo_web_client.web;

import com.example.demo_web_client.model.User;
import com.example.demo_web_client.service.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    @Autowired
    private  Producer producer;


    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody User user) {

        this.producer.sendMessage(user);
    }
}
