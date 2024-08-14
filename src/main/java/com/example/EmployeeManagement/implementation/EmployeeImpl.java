package com.example.EmployeeManagement.implementation;

import com.example.EmployeeManagement.entity.Employee;

import java.util.List;

public interface EmployeeImpl {

    List<Employee> getAllEmployees();

    Employee getEmployee(long employeeId);

    Employee addNewEmployee(Employee employee);

    Employee updateEmployee(Long employeeId, Employee employee) throws Exception;

    void deleteEmployee(Long employeeId) throws Exception;
}
