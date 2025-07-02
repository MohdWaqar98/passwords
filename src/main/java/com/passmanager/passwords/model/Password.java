package com.passmanager.passwords.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passwords")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Password {
    @Id
    private String id;
    private String site;
    private String username;
    private String password;
}

