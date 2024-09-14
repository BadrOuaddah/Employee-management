package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.base.BaseController;
import com.example.EmployeeManagement.base.BaseService;
import com.example.EmployeeManagement.entity.Manager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/managers")
@Slf4j
public class ManagerController extends BaseController<Manager, Long> {
    public ManagerController(BaseService<Manager, Long> service) {
        super(service);
    }
}
