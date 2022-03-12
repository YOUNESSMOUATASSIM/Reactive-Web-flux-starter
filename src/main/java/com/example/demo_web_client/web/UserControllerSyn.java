package com.example.demo_web_client.web;

import com.example.demo_web_client.dao.UserReactiveRepo;
import com.example.demo_web_client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/Api-users")
public class UserControllerSyn {
    @Autowired
    UserReactiveRepo userRepo;


    @GetMapping(value = "/")
    public Flux<User> findAll() {

        return userRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<User> findById(@PathVariable("id") String id) {

        return userRepo.findById(id);

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepo.insert(user);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> update(@PathVariable( "id" ) String id, @RequestBody User user) {
        user.setId(id);
        return userRepo.save(user);

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> delete(@PathVariable("id") String id) {

        return userRepo.deleteById(id);
    }

}
