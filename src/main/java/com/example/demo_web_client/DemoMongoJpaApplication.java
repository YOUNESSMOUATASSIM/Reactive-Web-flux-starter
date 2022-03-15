package com.example.demo_web_client;


import com.example.demo_web_client.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoMongoJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMongoJpaApplication.class, args);
    }
/*    @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {

//            userRepo.save(new User("7","younes"));
//              userService.fillUsersSynchronous();
                userService.fillUsersAsynchronous();
        };
    }*/
}
