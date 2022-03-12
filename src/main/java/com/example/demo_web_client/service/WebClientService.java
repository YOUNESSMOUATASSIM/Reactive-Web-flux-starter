package com.example.demo_web_client.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@AllArgsConstructor @NoArgsConstructor

@Service
public class WebClientService implements IWebClientHttp{
    HttpClient httpClient = HttpClient.create();
    WebClient webClient ;
    @Value("${token.app.jwtSecret}")
    String token;
//    String url;//"https://gorest.co.in/public/v2/users"
    @Override
    public WebClient  getWebClientByUrl(String url){

                    return webClient = WebClient.builder()
                             .clientConnector(new ReactorClientHttpConnector(httpClient))
                             .baseUrl(url)
                             .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                             .defaultHeader(HttpHeaders.AUTHORIZATION,token)
                             .build();
                 }

}

