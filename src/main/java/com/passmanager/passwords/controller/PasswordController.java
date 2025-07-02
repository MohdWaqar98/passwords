package com.passmanager.passwords.controller;

import com.passmanager.passwords.model.Password;
import com.passmanager.passwords.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/passwords")
public class PasswordController {

    @Autowired
    private PasswordRepository repository;

    @GetMapping
    public List<Password> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Password addPassword(@RequestBody Password password) {
        return repository.save(password);
    }

    @PutMapping("/{id}")
    public Password updatePassword(@PathVariable String id, @RequestBody Password password) {
        password.setId(id);
        return repository.save(password);
    }

    @DeleteMapping("/{id}")
    public void deletePassword(@PathVariable String id) {
        repository.deleteById(id);
    }
}
