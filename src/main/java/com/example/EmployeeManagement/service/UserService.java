package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.User;
import com.example.EmployeeManagement.implementation.UserImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserImpl {

    public List<User> getAllUsers() {
        return null;
    }

    public User getUser(long userId) {
        return null;
    }

    public User addNewUser(User user) {
        return null;
    }

    public User updateUser(Long userId, User user) throws Exception {
        return null;
    }

    public void deleteUser(Long userId) throws Exception {

    }
}
