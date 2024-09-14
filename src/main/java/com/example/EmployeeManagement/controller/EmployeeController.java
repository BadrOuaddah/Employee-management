package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.base.BaseController;
import com.example.EmployeeManagement.base.BaseService;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
@Slf4j
public class EmployeeController extends BaseController<Employee, Long> {

    private final EmployeeService employeeService;

    public EmployeeController(BaseService<Employee, Long> service, EmployeeService employeeService) {
        super(service);
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/view/{employeeId}")
    public ResponseEntity<Optional<Employee>> viewEmployee(@PathVariable Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployeeForView(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
