package com.passmanager.passwords.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.passmanager.passwords.model.Password;

public interface PasswordRepository extends MongoRepository<Password, String> {
}