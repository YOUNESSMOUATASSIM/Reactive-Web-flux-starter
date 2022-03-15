package com.example.demo_web_client.repositories;

import com.example.demo_web_client.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReactiveRepo extends ReactiveMongoRepository<User,String> {
}
