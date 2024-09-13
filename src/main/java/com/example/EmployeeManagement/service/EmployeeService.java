package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.base.BaseRepository;
import com.example.EmployeeManagement.base.BaseService;
import com.example.EmployeeManagement.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseService<Employee, Long> {
    public EmployeeService(BaseRepository<Employee, Long> repository) {
        super(repository);
    }
}
