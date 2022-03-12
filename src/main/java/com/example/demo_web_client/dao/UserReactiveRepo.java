package com.example.demo_web_client.dao;

import com.example.demo_web_client.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserReactiveRepo extends ReactiveMongoRepository<User,String> {
}
