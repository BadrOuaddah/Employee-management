package com.example.EmployeeManagement.controller;


import com.example.EmployeeManagement.entity.User;
import com.example.EmployeeManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long userId) {
        Optional<User> userOptional = userService.getUser(userId);
        return new ResponseEntity<>(userOptional, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user) {
        User addedNewUser = userService.addNewUser(user);
        return new ResponseEntity<>(addedNewUser, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<User> putUser(@PathVariable Long userId, @RequestBody User user) throws Exception {
        User updateUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable Long userId) throws Exception {
        userService.deleteUser(userId);

    }

}
