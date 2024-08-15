package com.example.basic_api.service;

import com.example.basic_api.domain.user.User;
import com.example.basic_api.domain.user.UserRequestDTO;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    public User createUser(UserRequestDTO data) {
        User newUser = new User();

        newUser.setName(data.name());
        newUser.setEmail(data.email());
        newUser.setPassword(data.password());

        return newUser;
    }
}
