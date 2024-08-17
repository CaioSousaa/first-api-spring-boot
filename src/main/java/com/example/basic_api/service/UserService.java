package com.example.basic_api.service;

import com.example.basic_api.domain.user.UpdateRequestDTO;
import com.example.basic_api.domain.user.User;
import com.example.basic_api.domain.user.UserRequestDTO;
import com.example.basic_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(UserRequestDTO data) {
        User newUser = new User();

        newUser.setName(data.name());
        newUser.setEmail(data.email());
        newUser.setPassword(data.password());

        userRepository.save(newUser);

        return newUser;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User updateUser(UUID id, UpdateRequestDTO data){
        User newUser = this.userRepository.findById(id).orElseThrow();

        newUser.setEmail(data.email());
        newUser.setPassword(data.password());
        newUser.setName(data.name());


        userRepository.save(newUser);

        return newUser;
    }

}
