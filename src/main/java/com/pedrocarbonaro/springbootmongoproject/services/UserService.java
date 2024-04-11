package com.pedrocarbonaro.springbootmongoproject.services;

import com.pedrocarbonaro.springbootmongoproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrocarbonaro.springbootmongoproject.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }
}
