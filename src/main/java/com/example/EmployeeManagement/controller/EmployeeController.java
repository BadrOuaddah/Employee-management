package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    public ResponseEntity<List<Employee>> getAllEmployees() {
        return null;
    }

    public ResponseEntity<Employee> getEmployee(long employeeId) {
        return null;
    }

    public ResponseEntity<Employee> postEmployee(Employee employee) {
        return null;
    }

    public ResponseEntity<Employee> putEmployee(Long employeeId, Employee employee) throws Exception {
        return null;
    }

    public void deleteEmployee(Long employeeId) throws Exception {

    }

}
