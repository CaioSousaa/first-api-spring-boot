package com.example.basic_api.controller;

import com.example.basic_api.domain.user.User;
import com.example.basic_api.domain.user.UserRequestDTO;
import com.example.basic_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserRequestDTO request) {
        User newUser = this.userService.createUser(request);

        return ResponseEntity.ok(newUser);
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
       return ResponseEntity.ok(this.userService.getUsers());
    }
}
