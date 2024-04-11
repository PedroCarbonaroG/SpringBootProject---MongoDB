package com.pedrocarbonaro.springbootmongoproject.controllers;

import com.pedrocarbonaro.springbootmongoproject.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User u1 = new User("1001", "Maria Brown", "maria@gmail.com");
        User u2 = new User("1002", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(u1, u2));
        return ResponseEntity.ok().body(list);
    }
}
