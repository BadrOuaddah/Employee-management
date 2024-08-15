package com.example.EmployeeManagement.implementation;

import com.example.EmployeeManagement.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserImpl {

    List<User> getAllUsers();

    Optional<User> getUser(long userId);

    User addNewUser(User user);

    User updateUser(Long userId, User user) throws Exception;

    void deleteUser(Long userId) throws Exception;
}
