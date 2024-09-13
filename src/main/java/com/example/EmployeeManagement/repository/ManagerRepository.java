package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.base.BaseRepository;
import com.example.EmployeeManagement.entity.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends BaseRepository<Manager, Long> {
}
