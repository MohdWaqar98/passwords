package com.passmanager.passwords.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.passmanager.passwords.model.Password;

public interface PasswordRepository extends MongoRepository<Password, String> {
    List<Password> findByUserId(String userId);
}
