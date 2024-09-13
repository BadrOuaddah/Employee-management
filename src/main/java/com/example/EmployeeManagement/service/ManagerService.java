package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.base.BaseRepository;
import com.example.EmployeeManagement.base.BaseService;
import com.example.EmployeeManagement.entity.Manager;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends BaseService<Manager, Long> {
    public ManagerService(BaseRepository<Manager, Long> repository) {
        super(repository);
    }
}
