package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.implementation.EmployeeImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeImpl {

    public List<Employee> getAllEmployees() {
        return null;
    }

    public Employee getEmployee(long employeeId) {
        return null;
    }

    public Employee addNewEmployee(Employee employee) {
        return null;
    }

    public Employee updateEmployee(Long employeeId, Employee employee) throws Exception {
        return null;
    }

    public void deleteEmployee(Long employeeId) throws Exception {

    }
}
