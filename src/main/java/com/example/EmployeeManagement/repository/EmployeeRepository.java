package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.base.BaseRepository;
import com.example.EmployeeManagement.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Long> {
}
