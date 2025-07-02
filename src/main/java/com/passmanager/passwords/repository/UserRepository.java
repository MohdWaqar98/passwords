package com.passmanager.passwords.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.passmanager.passwords.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}