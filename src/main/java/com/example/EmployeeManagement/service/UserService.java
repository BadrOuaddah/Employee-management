package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.User;
import com.example.EmployeeManagement.implementation.UserImpl;
import com.example.EmployeeManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserImpl {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(long userId) {
        return userRepository.findById(userId);
    }

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user) throws Exception {
        userRepository.findById(userId).orElseThrow(() -> new Exception("Employee not found with id : " + userId));
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) throws Exception {
        userRepository.findById(userId).orElseThrow(() -> new Exception("Employee not found with id : " + userId));
        userRepository.deleteById(userId);
    }
}
