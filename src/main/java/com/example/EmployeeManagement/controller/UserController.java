package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.base.BaseController;
import com.example.EmployeeManagement.base.BaseService;
import com.example.EmployeeManagement.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
@Slf4j
public class UserController extends BaseController<User, Long> {
    public UserController(BaseService<User, Long> service) {
        super(service);
    }
}
