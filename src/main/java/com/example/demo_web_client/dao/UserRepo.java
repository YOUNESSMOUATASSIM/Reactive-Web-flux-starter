package com.example.demo_web_client.dao;

import com.example.demo_web_client.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
}
