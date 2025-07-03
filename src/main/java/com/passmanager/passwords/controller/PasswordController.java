package com.passmanager.passwords.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passmanager.passwords.model.Password;
import com.passmanager.passwords.repository.PasswordRepository;
import com.passmanager.passwords.security.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/passwords")
@RequiredArgsConstructor
public class PasswordController {

    private final PasswordRepository repository;
    private final JwtUtil jwtUtil;

    @GetMapping
    public List<Password> getAll(HttpServletRequest request) {
        String userId = getUserIdFromToken(request);
        return repository.findByUserId(userId);
    }

    @PostMapping
    public Password addPassword(@RequestBody Password password, HttpServletRequest request) {
        String userId = getUserIdFromToken(request);
        password.setUserId(userId);
        return repository.save(password);
    }

    @PutMapping("/{id}")
    public Password updatePassword(@PathVariable String id, @RequestBody Password password, HttpServletRequest request) {
        String userId = getUserIdFromToken(request);
        password.setId(id);
        password.setUserId(userId); 
        return repository.save(password);
    }

    @DeleteMapping("/{id}")
    public void deletePassword(@PathVariable String id, HttpServletRequest request) {
        String userId = getUserIdFromToken(request);
        Password pass = repository.findById(id).orElse(null);
        if (pass != null && pass.getUserId().equals(userId)) {
            repository.deleteById(id);
        }
    }

    private String getUserIdFromToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        return jwtUtil.extractUserId(token);
    }
}
