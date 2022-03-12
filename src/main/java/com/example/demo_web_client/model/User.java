package com.example.demo_web_client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor @NoArgsConstructor @Data
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
