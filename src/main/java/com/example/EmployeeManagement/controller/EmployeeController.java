package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(path = "/view/{employeeId}")
    public ResponseEntity<Optional<Employee>> viewEmployee(@PathVariable Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
        Employee addedNewEmployee = employeeService.addNewEmployee(employee);
        return new ResponseEntity<>(addedNewEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<Employee> putEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) throws Exception {
        Employee updateEmployee = employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) throws Exception {
        employeeService.deleteEmployee(employeeId);
    }

}
