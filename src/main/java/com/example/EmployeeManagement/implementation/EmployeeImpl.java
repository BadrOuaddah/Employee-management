package com.example.EmployeeManagement.implementation;

import com.example.EmployeeManagement.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeImpl {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployee(long employeeId);

    Employee addNewEmployee(Employee employee);

    Employee updateEmployee(Long employeeId, Employee employee) throws Exception;

    void deleteEmployee(Long employeeId) throws Exception;
}
