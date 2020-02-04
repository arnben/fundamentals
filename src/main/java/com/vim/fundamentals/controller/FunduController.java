package com.vim.fundamentals.controller;

import com.vim.fundamentals.model.FunduUser;
import com.vim.fundamentals.repository.FunduRepository;
import com.vim.fundamentals.service.FunduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class FunduController {

    @Autowired
    private FunduRepository repository;

    @Autowired
    private FunduService service;

    @GetMapping(value = "/home")
    public FunduResponse getHome() {
        FunduResponse fundu = new FunduResponse();
        fundu.setMessage("Hello");
        return fundu;
    }

    @PostMapping(value = "/user")
    public ResponseEntity addUser(@RequestBody FunduUser user) {
        FunduUser recUser = service.reconcileUserEmail(user);
        repository.save(recUser);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/user")
    public ResponseEntity<GetAllUsersRepsonse> getAllUsers() {
        Iterable<FunduUser> users = repository.findAll();
        return ResponseEntity.of(Optional.of(new GetAllUsersRepsonse(users)));
    }
}
