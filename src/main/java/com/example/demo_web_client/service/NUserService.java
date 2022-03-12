package com.example.demo_web_client.service;

import com.example.demo_web_client.dao.UserReactiveRepo;
import com.example.demo_web_client.dao.UserRepo;
import com.example.demo_web_client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;
import reactor.core.publisher.Flux;

import java.util.UUID;

//implements UserService
@Service
public class NUserService implements UserService{
    @Autowired
    UserRepo userRepoNonReactive;
    @Autowired
    IWebClientHttp iwebClientHttp;
    @Autowired
    UserReactiveRepo userRepo;
    // WONT WORK I DONT KNOW WHY !!
//    @Autowired

    @Test
    @Override
    public void fillUsersSynchronous() {

            userRepoNonReactive.deleteAll();
            User[] response = iwebClientHttp.getWebClientByUrl("https://gorest.co.in/public/v2/users")
                    .get()
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(User[].class)
                    .block();


            assert response != null;
            for (User value : response) {

                User user = new User();
                user.setId(UUID.randomUUID().toString());
                user.setName(value.getName());
                user.setEmail(value.getEmail());
                user.setGender(value.getGender());
                user.setStatus(value.getStatus());
                userRepoNonReactive.save(user);
            }
             System.out.println("SYNCHRONOUS COMPLETED SUCCESSFULLY !!!!");
    }

    @Test
    @Override
    public void fillUsersAsynchronous() {

       userRepo.deleteAll().subscribe(null,null,()-> {
           iwebClientHttp.getWebClientByUrl("https://gorest.co.in/public/v2/users")
                   .method(HttpMethod.GET)
                   .exchangeToFlux(response -> {
                       if (response.statusCode().equals(HttpStatus.OK)) return response.bodyToFlux(User.class);

                       return response.createException().flatMapMany(Flux::error);
                   }).doOnComplete(() -> System.out.println("ASYNCHRONOUS COMPLETED SUCCESSFULLY !!!!"))
                     .toStream().forEach(
                           user -> {

                               User user1 = new User();
                               user1.setId(UUID.randomUUID().toString());
                               user1.setName(user.getName());
                               user1.setEmail(user.getEmail());
                               user1.setGender(user.getGender());
                               user1.setStatus(user.getStatus());
                               userRepo.save(user1).subscribe(u -> {


                               });

                           }
                   );
       });



    }

}
