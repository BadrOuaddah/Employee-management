package com.example.EmployeeManagement.implementation;

import com.example.EmployeeManagement.entity.User;

import java.util.List;

public interface UserImpl {

    List<User> getAllUsers();

    User getUser(long userId);

    User addNewUser(User user);

    User updateUser(Long userId, User user) throws Exception;

    void deleteUser(Long userId) throws Exception;
}
