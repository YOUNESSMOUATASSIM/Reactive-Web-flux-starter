package com.example.demo_web_client.service;

import org.springframework.web.reactive.function.client.WebClient;

public interface IWebClientHttp {
    WebClient getWebClientByUrl(String url);
}
