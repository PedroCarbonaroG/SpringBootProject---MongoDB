package com.pedrocarbonaro.springbootmongoproject.services;

import com.pedrocarbonaro.springbootmongoproject.repository.UserRepository;
import com.pedrocarbonaro.springbootmongoproject.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrocarbonaro.springbootmongoproject.domain.User;
import com.pedrocarbonaro.springbootmongoproject.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        if (list.isEmpty()) { throw new ObjectNotFoundException("None Objects were found!"); }
        return list;
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object id wasn't found!"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
