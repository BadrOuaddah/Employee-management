package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    public ResponseEntity<List<User>> getAllUsers() {
        return null;
    }

    public ResponseEntity<User> getUser(long userId) {
        return null;
    }

    public ResponseEntity<User> postUser(User user) {
        return null;
    }

    public ResponseEntity<User> putUser(Long userId, User user) throws Exception {
        return null;
    }

    public void deleteUser(Long userId) throws Exception {

    }

}
