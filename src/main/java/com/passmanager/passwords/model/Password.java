package com.passmanager.passwords.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "passwords")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Password {
    @Id
    private String id;
    private String site;
    private String username;
    private String password;
    private String userId;
}
