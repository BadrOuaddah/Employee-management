package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.base.BaseRepository;
import com.example.EmployeeManagement.base.BaseService;
import com.example.EmployeeManagement.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, Long> {
    public UserService(BaseRepository<User, Long> repository) {
        super(repository);
    }
}
