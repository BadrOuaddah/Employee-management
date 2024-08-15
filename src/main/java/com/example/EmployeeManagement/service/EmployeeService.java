package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.implementation.EmployeeImpl;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeImpl {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, Employee employee) throws Exception {
        employeeRepository.findById(employeeId).orElseThrow(() -> new Exception("Employee not found with id : " + employeeId));
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) throws Exception {
        employeeRepository.findById(employeeId).orElseThrow(() -> new Exception("Employee not found with id : " + employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
