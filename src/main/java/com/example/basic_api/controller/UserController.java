package com.example.basic_api.controller;

import com.example.basic_api.domain.user.UpdateRequestDTO;
import com.example.basic_api.domain.user.User;
import com.example.basic_api.domain.user.UserRequestDTO;
import com.example.basic_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id , @RequestBody UpdateRequestDTO request) {
        User newUser = this.userService.updateUser(id, request);

        return ResponseEntity.ok(newUser);
    }
}
